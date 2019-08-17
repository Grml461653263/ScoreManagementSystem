package com.my.score.controller;

import com.my.score.server.CollegeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("college")
public class CollegeController {

    @Autowired
    private CollegeServer cs;
    /**
     * 获取各学院信息
     * @return
     */

    @PostMapping("info")
    @ResponseBody
    public Map<String,Object> getCollegeInfo(){

        return cs.getCollegeInfo();
    }

    @PostMapping("stu")
    @ResponseBody
    public Map<String,Object> getStuInfo(){

        return cs.getStuInfo();
    }
}
