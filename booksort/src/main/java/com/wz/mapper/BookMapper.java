package com.wz.mapper;

import com.wz.domain.Book;
import com.wz.domain.BookVo;
import com.wz.general.GeneralDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookMapper extends GeneralDAO<Book> {
    public List<BookVo> findAll(Integer eid);
}