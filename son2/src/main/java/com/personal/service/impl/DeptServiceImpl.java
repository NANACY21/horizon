package com.personal.service.impl;

import com.personal.service.DeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Override
    public void adda() {
        System.out.println("DeptServiceImpl adda()执行");
    }

    @Override
    public void del() {
        System.out.println("DeptServiceImpl del()执行");
    }
}
