package com.my.score.server;

import com.alibaba.fastjson.JSONArray;
import com.my.score.mapper.ClassMapper;
import com.my.score.mapper.ScoreMapper;
import com.my.score.mapper.SpecialtyMapper;
import com.my.score.mapper.StudentMapper;
import com.my.score.pojo.Class;
import com.my.score.pojo.Score;
import com.my.score.pojo.Specialty;
import com.my.score.pojo.Student;
import com.my.score.utils.ExeclOut;
import com.my.score.utils.OpinionExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class ScoreServer {

    @Autowired
    private ScoreMapper sm;
    @Autowired
    private ClassMapper cm;
    @Autowired
    private SpecialtyMapper spm;
    @Autowired
    private StudentMapper stm;
    public Map<String,Object> getScore(String key, Integer page, Integer rows, String sortBy, Boolean desc, Integer id) {

        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> parms = new HashMap<String, Object>();
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        parms.put("key",key);
        parms.put("sortBy",sortBy);
        if(desc != null) {
            parms.put("desc", desc ? 1 : 0);
        }
        parms.put("cid",id);
         result = sm.getScore(parms);

        if(result.isEmpty() && result.size() ==0){
          result = sm.getScore1(parms);
        }else {
            List<Map<String, Object>> score = sm.getScore1(parms);
            result.addAll(score);
        }
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

    public Map insertScore(String name, Integer source, String aClass, String id,Integer semester,Integer sid,Integer cid,Integer ssid) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",ssid);
        map.put("source",source);
        sm.update1(map);
        return map;
    }

    public Map<String, Object> insert(String name, Integer source, String letter, Integer semester,String spe) {
        Map<String,Object> map = new HashMap<String, Object>();
        Example ce = new Example(Class.class);
        ce.createCriteria().andEqualTo("name",letter);
        List<Class> classes = cm.selectByExample(ce);
        int cid = classes.get(0).getId();
        Example se = new Example(Specialty.class);
        se.createCriteria().andEqualTo("name",spe);
        int id = spm.selectByExample(se).get(0).getId();
        Example stue = new Example(Student.class);
        stue.createCriteria().andEqualTo("name",name).andEqualTo("cid",cid);
        int i = stm.selectByExample(stue).get(0).getId();
        Score score = new Score();
        score.setSemester(semester);
        score.setScore(source);
        score.setsId(id);
        score.setcId(cid);
        score.setStudentId(i);
        sm.insert(score);
        map.put("msg","新增一条数据"+score.toString());
        return map;
    }

    public Map<String, Object> updateSource(Integer ssid) {
        Map<String,Object> map = new HashMap<String, Object>();
        Example stue = new Example(Score.class);
        stue.createCriteria().andEqualTo("id",ssid);
        sm.deleteByExample(stue);
        map.put("msg","success!");
        return map;

    }

    public void excelOut(String key, String sortBy, Boolean desc, Integer id, HttpServletResponse res) {
        Map<String,Object> parms = new HashMap<String, Object>();
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        parms.put("key",key);
        parms.put("sortBy",sortBy);
        if(desc != null) {
            parms.put("desc", desc ? 1 : 0);
        }
        parms.put("cid",id);
        result = sm.getScore(parms);
        if(result.isEmpty() && result.size() ==0){
            result = sm.getScore1(parms);
        }else {
            List<Map<String, Object>> score = sm.getScore(parms);
            result.addAll(score);
        }
        HashMap<String,String> hard = new LinkedHashMap<String, String>();
        hard.put("num","编号");
        hard.put("id","学号");
        hard.put("name","姓名");
        hard.put("spe","专业");
        hard.put("cla","班级");
        hard.put("source","成绩");
        hard.put("semester","学期");
        JSONArray ja = new JSONArray();
        int i = 1;
        for (Map map : result) {
            String spe = map.get("spe").toString();
            OpinionExcelVo opex = new OpinionExcelVo();
            opex.setNum(i);
            opex.setId(map.get("id").toString());
            opex.setName(map.get("name").toString());
            opex.setSpe(spe);
            opex.setCla(map.get("letter").toString());
            opex.setSource(Integer.parseInt(map.get("source").toString()));
            opex.setSemester(map.get("semester").toString());
            ja.add(opex);
            i++;
        }
        String name = id==1?"计算机":id==2?"网络":id==3?"信工":id==5?"会计":id==6?"服装":"";
        ExeclOut.downloadExcelFile(name+"成绩名单", hard, ja, res);
    }
}
