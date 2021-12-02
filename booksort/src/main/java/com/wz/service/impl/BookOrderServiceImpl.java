package com.wz.service.impl;

import com.wz.domain.BookVo;
import com.wz.domain.Bookorder;
import com.wz.mapper.BookMapper;
import com.wz.mapper.BookorderMapper;
import com.wz.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class BookOrderServiceImpl implements BookOrderService {
    @Autowired
    BookorderMapper bookorderMapper;
@Autowired
    BookMapper bookMapper;
    @Override
    public List<Bookorder> selectAllbook(Integer eid) {
        Example example = new Example(Bookorder.class);
        example.createCriteria().andEqualTo("rid",eid);
        List<Bookorder> bookorders = bookorderMapper.selectByExample(example);
        return bookorders;
    }

    @Override
    public int update(Bookorder bookorder) {
        int i = bookorderMapper.updateByPrimaryKey(bookorder);
        return i;
    }

    @Override
    public int aadd(Bookorder bookorder) {
        int insert = bookorderMapper.insert(bookorder);
        return insert;
    }

    @Override
    public int delete(Integer orderid) {
        int i = bookorderMapper.deleteByPrimaryKey(orderid);
        return i;
    }
}
