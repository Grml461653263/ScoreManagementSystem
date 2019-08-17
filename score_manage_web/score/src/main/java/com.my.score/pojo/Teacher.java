package com.my.score.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int work_id;
    private String name;
    private int age;
    private int sex;
    private Date birth;
    private String phone;
    private int school_age;
    private String graduate;
    private String degree;
    private String email;
    private Date create_time;
    private Date up_time;
    private int delete;
    private String remarks;
}
