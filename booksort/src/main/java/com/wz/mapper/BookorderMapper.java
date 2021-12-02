package com.wz.mapper;

import com.wz.domain.BookVo;
import com.wz.domain.Bookorder;
import com.wz.general.GeneralDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookorderMapper extends GeneralDAO<Bookorder> {
    public List<BookVo> findAll(Integer eid);}