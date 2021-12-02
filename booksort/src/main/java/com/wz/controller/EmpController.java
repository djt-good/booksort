package com.wz.controller;

import com.wz.domain.Emp;
import com.wz.service.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpServices empServices;
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        Emp emp = empServices.find1(username, password);
        if(emp !=null){
            session.setAttribute("empp",emp);
        }
        return "admin";
    }
    @RequestMapping("/find")
    public String find(Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Emp> emps = empServices.find();
        Emp emp = empServices.select(id);
        if(emp.getGrade() ==1){
          request.setAttribute("emp",emps);
            return "emp";
        }else {
           return "forward:/pages/error.jsp";
        }


    }

    @RequestMapping("/add")
    public String regist(Emp emp, HttpSession session){
        Integer register = empServices.add(emp);
       return "forward:/emp/find";
    }

    @RequestMapping("/update")
    @ResponseBody
    public int update(Emp emp,HttpServletRequest request){
        int update = empServices.update(emp);
        return update;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer id){
        int delete = empServices.delete(id);
        return delete;
    }

}
