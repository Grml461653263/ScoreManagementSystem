package com.my.score.controller;

import com.my.score.server.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService ss;

    @GetMapping("get")
    @ResponseBody
    public Map<String,Object> getScore(Integer page,Integer rows,String sortBy,Boolean desc,String key){
        return ss.getScore(page,rows,sortBy,desc,key);
    }

    @PostMapping("deleted")
    @ResponseBody
    public Map<String,Object> updateScore(Integer ssid){


        return ss.updateSource(ssid);
    }

    @GetMapping("excel")
    @ResponseBody
    public void excelOut( String key,String sortBy, Boolean desc,  HttpServletResponse res){
        ss.excelOut(sortBy,desc,key,res);
    }
}
