package com.wz.service.impl;

import com.wz.domain.Reader;
import com.wz.mapper.ReaderMapper;
import com.wz.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    ReaderMapper readerMapper;
    @Override
    public List<Reader> selectreder() {
        List<Reader> selectreder = readerMapper.selectAll();
        return selectreder;
    }

    @Override
    public int add(Reader reader) {
        int insert = readerMapper.insert(reader);
        return insert;
    }

    @Override
    public int update(Reader reader) {
        int i = readerMapper.updateByPrimaryKey(reader);
        return i;
    }

    @Override
    public int delete(Integer eid) {
        int i = readerMapper.deleteByPrimaryKey(eid);
        return i;
    }
}
