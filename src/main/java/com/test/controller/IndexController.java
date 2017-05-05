package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.test.dao.AdminDao;
import com.test.dao.StaffDao;
import com.test.entity.Admin;
import com.test.entity.Staff;
import com.test.entity.page.StaffPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhengying 2017年05月02日11:19:44
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private AdminDao adminDao;

    @RequestMapping("testSql")
    @ResponseBody
    public List<Staff> testSql() {
        return staffDao.getAllStaffInfos();
    }

    /**
     * 登陆页
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(Model model) {
        return "index/login";
    }

    @RequestMapping("checkLogin")
    @ResponseBody
    public int checkLogin(String username, String password, HttpSession session) {

        Admin admin = adminDao.getAdminByName(username);
        if(admin == null || !password.equals(admin.getPassword())){
            return 1;
        }
        session.setAttribute("login_admin", admin);
        return 0;     //0000:登录成功 1：用户名错误，2：错误，3：。。。
    }

    @RequestMapping("register")
    @ResponseBody
    public int register(String username, String password) {
        Admin admin = adminDao.getAdminByName(username);
        if(admin != null){
            return 1;
        }
        Admin tmp = new Admin();
        tmp.setAdminName(username);
        tmp.setPassword(password);

        adminDao.registerAdmin(tmp);
        return 0;     //0000:注册成功 1：用户名已经存在
    }


    /**
     * 所有员工详情页
     * @param model
     * @return
     */
    @RequestMapping("staffsInfo")
    public String staffsInfo(Model model, StaffPage page) {

        page.setTotalRows(staffDao.getSumStaffs());
        //分页插件
        PageHelper.startPage(page.getStartPage(), page.getPageSize());
        List<Staff> staffs = staffDao.getAllStaffInfos();
        model.addAttribute("page", page);
        model.addAttribute("staffs", staffs);
        return "staff/staffs";
    }

    @RequestMapping("deleteStaff")
    public String deleteStaff(String startPage, String id) {
        staffDao.deleteStaffById(id);
        return "redirect:staffsInfo?startPage="+startPage;
    }

    @RequestMapping("addStaff")
    @ResponseBody
    public int addStaff(Staff staff) {

        staffDao.addStaff(staff);

        System.out.println(staff.toString());
        return 0;
    }

    @RequestMapping("updateStaff")
    @ResponseBody
    public int updateStaff(Staff staff, StaffPage page) {
        int result = 0;
        try{
            staffDao.updateStaff(staff);
        }catch (Exception e){
            result = 1;
        }
        return result;
    }


}
