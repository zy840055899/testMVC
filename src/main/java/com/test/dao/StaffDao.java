package com.test.dao;

import com.test.entity.Staff;

import java.util.List;

public interface StaffDao {
    List<Staff> getAllStaffInfos();
    int getSumStaffs();
    List<Staff> getAllStaffInfos2();
    void deleteStaffById(String id);
    void addStaff(Staff staff);
    void updateStaff(Staff staff);
}
