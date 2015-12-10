package com.test.dao;

import com.test.annotation.MyRepository;
import com.test.entity.Student;

import java.util.List;

@MyRepository
public interface TestDao
{
    List<Student> testSql();
    Student getStuById(int id);
    List<Student> getNeedStaticStus();
    int updateStaticTime(int id);
}
