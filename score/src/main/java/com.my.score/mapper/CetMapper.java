package com.my.score.mapper;

import com.my.score.pojo.Cet;
import com.my.score.utils.MyMapper;

import java.util.List;
import java.util.Map;

public interface CetMapper extends MyMapper<Cet> {
    List<Map<String, Object>> getCollegeInfo(Map<String, Object> parms);
}
