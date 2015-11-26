package com.test.dao;

import com.test.annotation.MyRepository;
import com.test.entity.Test;

import java.util.List;

@MyRepository
public interface TestDao
{
    List<Test> testSql();
}
