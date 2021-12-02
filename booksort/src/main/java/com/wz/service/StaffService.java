package com.wz.service;

import com.wz.domain.Staff;

import java.util.List;

public interface StaffService {
    public List<Staff> find();
    public int update(Staff staff);
    public int add(Staff staff);
    public int delete(Integer  id);
}
