package com.my.score.mapper;

import com.my.score.pojo.Student;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface StudentMapper extends Mapper<Student> {

    @Select("SELECT sname as name ,count(0) as value from student where 1=1 GROUP BY sname")
    List<Map<String,Object>> queryCollegeStudentCount();
    @Select("select class_name name,count(0) as value from student group by class_name ")
    List<Map<String, Object>> groupByStu();

    Map<String, Object> selectByclass(Map<String, Object> map1);

    List<Map<String, Object>> getStudentInfo(Map<String, Object> parms);

    //springdate jpa

}
