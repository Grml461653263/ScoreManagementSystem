package com.my.score.mapper;

import com.my.score.pojo.Score;
import com.my.score.utils.MyMapper;

import java.util.List;
import java.util.Map;

public interface ScoreMapper extends MyMapper<Score> {

    List<Map<String, Object>> getScore(Map<String, Object> map);

    List<Map<String, Object>> getScore1(Map<String, Object> map);
    void update1(Map<String, Object> map);
}
