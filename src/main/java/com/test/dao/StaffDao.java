package com.test.dao;

import com.test.annotation.MyRepository;
import com.test.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyRepository
public interface StaffDao {
    List<Staff> getAllStaffInfos();
    int getSumStaffs();
    List<Staff> getAllStaffInfos2();
    void deleteStaffById(String id);
    void addStaff(Staff staff);
    void updateStaff(Staff staff);
}
