package com.test.dao;

import com.test.annotation.MyRepository;
import com.test.entity.Admin;

@MyRepository
public interface AdminDao {
    Admin getAdminByName(String username);
    void registerAdmin(Admin admin);
}
