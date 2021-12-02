package com.wz.controller;

import com.wz.domain.BookVo;
import com.wz.domain.Bookorder;
import com.wz.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class BookOrderController {
    @Autowired
    BookOrderService bookOrderService;
    @RequestMapping("/find")
    public String find(Integer eid, HttpServletRequest request){
        List<Bookorder> bookVos = bookOrderService.selectAllbook(eid);
        HttpSession session = request.getSession(false);

            request.setAttribute("vo",bookVos);
            return "redersort";

    }

    @RequestMapping("/add")
    public String add(Bookorder bookorder){
   bookOrderService.aadd(bookorder);

        return "forward:/order/find";
    }
    @RequestMapping("/update")
    @ResponseBody
    public int update(Bookorder bookorder){
        int update = bookOrderService.update(bookorder);

        return update;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(Integer orderid){
        int delete = bookOrderService.delete(orderid);

        return delete;
    }
}
