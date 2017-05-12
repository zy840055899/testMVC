package com.test.dao;

import com.test.entity.Admin;

public interface AdminDao {
    Admin getAdminByName(String username);
    void registerAdmin(Admin admin);
}
