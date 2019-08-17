package com.my.score.server;

import com.my.score.mapper.CollegeMapper;
import com.my.score.mapper.CreditMapper;
import com.my.score.mapper.StudentMapper;
import com.my.score.pojo.College;
import com.my.score.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeServer {

    @Autowired
    private StudentMapper sm;
    @Autowired
    private CollegeMapper cm;

    @Autowired
    CreditMapper cdm;

    public Map<String,Object> getCollegeInfo(){
        Map<String,Object> map = new HashMap<String, Object>();

        /*int b = 10/0;*/
        //xueyuan xuesheng fenbu
        List<Map<String,Object>> smap = sm.queryCollegeStudentCount();
        //xueyuan jihe
        List<College> colleges = cm.selectAll();
        List<String> sl = new ArrayList<String>();
        List<Double> cl = new ArrayList<Double>();
        for (int i = 0; i < colleges.size(); i++) {
            String name = colleges.get(i).getName();
            sl.add(name);
            Map<String, Object> credit = cdm.countCreditByCollege(colleges.get(i).getId());
            Object value = credit.get("value");
            double parseDouble = Double.parseDouble(value.toString());
            cl.add(parseDouble);

        }
        map.put("studentAndCollege",smap);
        map.put("college",sl);
        map.put("list",cl);
        return map;
    }

    public Map<String, Object> getStuInfo() {
        Map<String,Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = sm.groupByStu();
        List<String> timeList = new ArrayList<String>();
        List<Integer> stuList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            timeList.add(list.get(i).get("name").toString());
            stuList.add(Integer.parseInt(list.get(i).get("value").toString()));
        }
        map.put("times",timeList);
        map.put("students",stuList);
        return map;
    }
}
