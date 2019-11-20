package com.personal.dao.impl;

import com.personal.dao.DeptDao;
import org.springframework.stereotype.Repository;

@Repository("DeptDao2")
public class DeptDaoImpl2 implements DeptDao {
    @Override
    public void add() {
        System.out.println("add dept_2");
    }
}
