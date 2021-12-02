package com.wz.controller;

import com.wz.domain.Reader;
import com.wz.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/reader")
public class ReaderController {
     @Autowired
    ReaderService readerService;
     @RequestMapping("/find")
    public String find(HttpServletRequest request){
         List<Reader> selectreder = readerService.selectreder();
         request.setAttribute("reader",selectreder);
         return "commonUserManage";
     }
    @RequestMapping("/add")

    public String add(Reader reader,HttpServletRequest request){
        int add = readerService.add(reader);
//        request.setAttribute("reader",selectreder);
        return "forward:/reader/find";
    }
    @RequestMapping("/update")
    @ResponseBody
    public int update(Reader reader,HttpServletRequest request){
        int update = readerService.update(reader);

        return update;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer eid,HttpServletRequest request){
        int delete = readerService.delete(eid);
        return delete;
    }
}
