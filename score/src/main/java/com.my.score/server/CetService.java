package com.my.score.server;

import com.alibaba.fastjson.JSONArray;
import com.my.score.mapper.CetMapper;
import com.my.score.mapper.StudentMapper;
import com.my.score.pojo.Cet;
import com.my.score.utils.DateUtil;
import com.my.score.utils.ExeclOut;
import com.my.score.utils.OpinionExcelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CetService {
    @Autowired
    private CetMapper cm;
    @Autowired
    private StudentMapper sm;
    public Map<String, Object> getCollegeInfo(String key, Integer page, Integer rows, String sortBy, Boolean desc, Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> parms = new HashMap<String, Object>();
        parms.put("key",key);
        parms.put("sortBy",sortBy);
        if(desc != null) {
            parms.put("desc", desc ? 1 : 0);
        }
        parms.put("cid",id);
        List<Map<String,Object>> result =cm.getCollegeInfo(parms);
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
        return  map;

    }

    public Map<String, Object> deleted(Integer id) {
        Map<String,Object> map = new HashMap<String, Object>();
        Example example = new Example(Cet.class);
        example.createCriteria().andEqualTo("id",id);
        int i = cm.deleteByExample(example);
        map.put("msg",i);
        return map;
    }

    public Map<String, Object> getInsertInfo(String name, String letter, String university, Integer source,Integer level,String time) {
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("name",name);
        map1.put("letter",letter);
        Map<String,Object> map2 =  sm.selectByclass(map1);
       Cet cet = new Cet();
        cet.setCet(level);
        cet.setClassName(letter);
        cet.setName(name);
        cet.setNumber(map2.get("number").toString());
        cet.setTime(time);
        cet.setUniversity(university);
        cet.setCource(source);
        int insert = cm.insert(cet);
        map.put("msg",insert);
        return map;
    }

    public void excelOut(String key, String sortBy, Boolean desc, Integer id, HttpServletResponse res) {
        Map<String,Object> parms = new HashMap<String, Object>();
        parms.put("key",key);
        parms.put("sortBy",sortBy);
        if(desc != null) {
            parms.put("desc", desc ? 1 : 0);
        }
        parms.put("cid",id);
        List<Map<String,Object>> result =cm.getCollegeInfo(parms);

        HashMap<String,String> hard = new LinkedHashMap<String, String>();
        hard.put("num","编号");
        hard.put("id","学号");
        hard.put("name","姓名");
        hard.put("cla","班级");
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
            opex.setSource(Integer.parseInt(map.get("source").toString()));
            opex.setUniversity(map.get("university").toString());
            ja.add(opex);
            i++;
        }
        ExeclOut.downloadExcelFile("cet"+(id==4?"四":"六"+"级成绩名单"), hard, ja, res);

    }


}
