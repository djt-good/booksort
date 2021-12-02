package com.wz.service.impl;

import com.wz.domain.Staff;
import com.wz.mapper.StaffMapper;
import com.wz.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;
    @Override
    public List<Staff> find() {
        List<Staff> staff = staffMapper.selectAll();
        return staff;
    }

    @Override
    public int update(Staff staff) {
        int i = staffMapper.updateByPrimaryKey(staff);
        return i;
    }

    @Override
    public int add(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public int delete(Integer id) {
        return staffMapper.deleteByPrimaryKey(id);
    }
}
