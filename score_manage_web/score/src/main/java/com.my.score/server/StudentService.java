package com.my.score.server;

import com.alibaba.fastjson.JSONArray;
import com.my.score.mapper.StudentMapper;
import com.my.score.pojo.Student;
import com.my.score.utils.ExeclOut;
import com.my.score.utils.OpinionExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentMapper sm;
    public Map<String, Object> getScore(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> parms = new HashMap<String, Object>();
        parms.put("key",key);
        parms.put("sortBy",sortBy);
        if(desc != null) {
            parms.put("desc", desc ? 1 : 0);
        }
        List<Map<String,Object>> result = sm.getStudentInfo(parms);
        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        if(rows!=-1){
            int start = (page-1)*rows;
            int end = start+rows;

            if(result.size()>end){
                maps = result.subList(start, end);
            }else {
                maps = result.subList(start,result.size());
            }
        }else{
            maps = result;
        }

        map.put("data",maps);
        map.put("total",result.size());
        return map;
    }

    public Map<String, Object> updateSource(Integer ssid) {
        Map<String,Object> map = new HashMap<String, Object>();
        Example example = new Example(Student.class);
        example.createCriteria().andEqualTo("id",ssid);
        Student student = new Student();
        student.setDelete(0);
       int i = sm.updateByExampleSelective(student,example);
       map.put("msg","删除"+i+"条");
       return map;
    }

    public void excelOut( String sortBy, Boolean desc, String  key, HttpServletResponse res) {
        Map<String,Object> parms = new HashMap<String, Object>();
        parms.put("key",key);
        parms.put("sortBy",sortBy);
        if(desc != null) {
            parms.put("desc", desc ? 1 : 0);
        }
        List<Map<String,Object>> result = sm.getStudentInfo(parms);
        System.out.println(result.toString());
        HashMap<String,String> hard = new LinkedHashMap<String, String>();
        hard.put("num","编号");
        hard.put("id","学号");
        hard.put("name","姓名");
        hard.put("cla","班级");
        hard.put("sex","性别");
        hard.put("phone","手机");
        hard.put("email","邮箱");
        hard.put("source","成绩");
        hard.put("university","学院");
        JSONArray ja = new JSONArray();
        int i = 1;
        for (Map map : result) {
            OpinionExcelVo opex = new OpinionExcelVo();
            opex.setNum(i);
            opex.setId(map.get("id").toString());
            opex.setName(map.get("name").toString());
            opex.setCla(map.get("letter").toString());
            opex.setSex(map.get("sex").equals("1")?"男":"女");
            opex.setPhone(map.get("phone").toString());
            opex.setEmail(map.get("email").toString());
            opex.setSource(Integer.parseInt(map.get("score").toString()));
            opex.setUniversity(map.get("university").toString());
            ja.add(opex);
            i++;
        }
        ExeclOut.downloadExcelFile("学生信息名单", hard, ja, res);
    }
}
