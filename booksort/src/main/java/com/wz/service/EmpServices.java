package com.wz.service;

import com.wz.domain.Emp;
import com.wz.domain.Reader;

import java.util.List;

public interface EmpServices {
    public Emp find1(String usename,String password);
    public Integer add(Emp emp);
    public List<Emp>  find();
    public int update(Emp emp);
    public int delete(Integer eid);

    Emp select(Integer id);
}
