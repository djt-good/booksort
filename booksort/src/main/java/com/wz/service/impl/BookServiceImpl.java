package com.wz.service.impl;

import com.wz.domain.Book;
import com.wz.mapper.BookMapper;
import com.wz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> findaAll() {
        List<Book> books = bookMapper.selectAll();
        return books;
    }

    @Override
    public int add(Book book) {
        int insert = bookMapper.insert(book);
        return insert;
    }

    @Override
    public int update(Book book) {
        int i = bookMapper.updateByPrimaryKey(book);
        return i;
    }
     @Override
    public int delete(Integer bid) {
        int i = bookMapper.deleteByPrimaryKey(bid);
        return i;
    }
}
