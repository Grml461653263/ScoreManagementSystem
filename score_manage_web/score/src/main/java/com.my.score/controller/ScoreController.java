package com.my.score.controller;

import com.my.score.server.ScoreServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private ScoreServer ss;

    @GetMapping("query")
    @ResponseBody
    public Map<String,Object> getScore(String key,Integer page,Integer rows,String sortBy,Boolean desc,Integer id){



        return ss.getScore(key,page,rows,sortBy,desc,id);
    }
    @PostMapping("deleted")
    @ResponseBody
    public Map<String,Object> updateScore(Integer ssid){


        return ss.updateSource(ssid);
    }


    @PutMapping("insert")
    @ResponseBody
    public Map<String,Object> insertScore(String name,String id,String letter,Integer source,Integer semester,Integer sid,Integer cid,Integer ssid){

        return ss.insertScore(name,source,letter,id,semester,sid,cid,ssid);
    }
    @PostMapping("insert")
    @ResponseBody
    public Map<String,Object> insert(String name,String letter,Integer source,Integer semester,String spe){

        return ss.insert(name,source,letter,semester,spe);
    }
    @GetMapping("excel")
    @ResponseBody
    public void excelOut(String key, String sortBy, Boolean desc, Integer id, HttpServletResponse res){
         System.out.println(id);
        ss.excelOut(key,sortBy,desc,id,res);
    }

}
