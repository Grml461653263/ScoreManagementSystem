package com.my.score.controller;

import com.my.score.server.CetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("cet")
public class CetController {
    @Autowired
    private CetService cs;

    @GetMapping("query")
    @ResponseBody
    public Map<String,Object> getCollegeInfo(String key,Integer page,Integer rows,String sortBy,Boolean desc,Integer id){

        return cs.getCollegeInfo(key,page,rows,sortBy,desc,id);
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String,Object> getInsertInfo(String name,String letter,String university,Integer source,Integer level,String time ){

        return cs.getInsertInfo(name,letter,university,source,level,time);
    }
    @GetMapping("deleted")
    @ResponseBody
    public Map<String,Object> deleted(Integer cid){

        return cs.deleted(cid);
    }

    @GetMapping("excelOut")
    @ResponseBody
    public void excelOut(String key, String sortBy, Boolean desc, Integer id, HttpServletResponse response){
     cs.excelOut(key,sortBy,desc,id,response);
    }

    /*@GetMapping("info")
    @ResponseBody
    public Map<String,Object> getCetInfo(){

        return cs.getCetInfo();
    }*/
}
