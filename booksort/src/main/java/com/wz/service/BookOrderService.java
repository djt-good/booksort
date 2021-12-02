package com.wz.service;

import com.wz.domain.BookVo;
import com.wz.domain.Bookorder;

import java.util.List;

public interface BookOrderService {
    public List<Bookorder> selectAllbook(Integer eid);
    public int update(Bookorder bookorder);
    public int aadd(Bookorder bookorder);
    public int delete(Integer orderid);
}
