package com.my.score.mapper;

import com.my.score.pojo.Credit;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface CreditMapper extends Mapper<Credit> {

    @Select("select avg(credit) as value from credit where s_id = #{id}")
    Map<String,Object> countCreditByCollege(int id);
}
