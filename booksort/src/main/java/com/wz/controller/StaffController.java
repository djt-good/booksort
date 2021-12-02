package com.wz.controller;

import com.wz.domain.Staff;
import com.wz.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;
    @RequestMapping("/find")
    public String find(HttpServletRequest request){
        List<Staff> staff = staffService.find();
        request.setAttribute("staff",staff);
        return "staff";
    }


    @RequestMapping("/add")
    public String add(Staff staff){
        staffService.add(staff);

        return "forward:/staff/find";
    }

    @RequestMapping("/update")
    @ResponseBody
    public int update(Staff staff){
     return staffService.update(staff);

    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer id){
    return staffService.delete(id);

    }
}
