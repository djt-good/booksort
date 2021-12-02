package com.wz.service;

import com.wz.domain.Book;

import java.util.List;

public interface BookService {
    public List<Book> findaAll();
    public int add(Book book);
    public int update(Book book);
    public int delete(Integer bid);
}
