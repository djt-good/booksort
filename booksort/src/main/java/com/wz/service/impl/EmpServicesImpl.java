package com.wz.service.impl;

import com.wz.domain.Emp;
import com.wz.mapper.EmpMapper;
import com.wz.service.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmpServicesImpl implements EmpServices {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp find1(String usename, String password) {
        Example example = new Example(Emp.class);
        example.createCriteria().andEqualTo("username",usename);
        Emp emp = empMapper.selectOneByExample(example);
        System.out.println(emp);
        if(emp !=null){
            if(password.equals(emp.getPassword())){
                return emp;
            }else {
                return null;
            }
        }

        return null;
    }

    @Override
    public Integer add(Emp emp) {
        int insert = empMapper.insert(emp);
        return insert;
    }

    @Override
    public List<Emp> find() {
        List<Emp> emps = empMapper.selectAll();
        return emps;
    }

    @Override
    public int update(Emp emp) {
        int i = empMapper.updateByPrimaryKey(emp);
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = empMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public Emp select(Integer id) {
        Emp emp = empMapper.selectByPrimaryKey(id);
        return emp;
    }
}
