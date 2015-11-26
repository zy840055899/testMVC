package com.test.dao;

import com.test.annotation.MyRepository;
import com.test.entity.TestEntity;

import java.util.List;

@MyRepository
public interface TestDao
{
    List<TestEntity> testSql();
}
