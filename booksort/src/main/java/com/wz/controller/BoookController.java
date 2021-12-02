package com.wz.controller;

import com.wz.domain.Book;
import com.wz.service.BookService;
import com.wz.service.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BoookController {
    @Autowired
    BookService bookService;
    @RequestMapping("/find")
    public String findAll(HttpServletRequest request){
        List<Book> books = bookService.findaAll();
        request.setAttribute("book",books);
        return "bookManage";
    }


    @RequestMapping("/add")
    public String add(Book book){
        int add = bookService.add(book);

        return "forward:/book/find";
    }
    @ResponseBody
    @RequestMapping("/update")
    public int update(Book book){
        int update = bookService.update(book);
        return update;
    }
    @ResponseBody
    @RequestMapping("/delete")
    public int delete(Integer bid){
        int delete = bookService.delete(bid);
        return delete ;
    }
}
