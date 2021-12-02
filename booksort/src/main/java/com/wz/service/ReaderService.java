package com.wz.service;

import com.wz.domain.Reader;

import java.util.List;

public interface ReaderService {
    public List<Reader> selectreder();
    public int add(Reader reader);
    public int update(Reader reader);
    public int delete(Integer eid);
}
