package com.personal.service.impl;

import com.personal.dao.DeptDao;
import com.personal.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * 该接口只有一个实现类，因此参数可省略，代表每类bean的id
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Lazy
    //接口有多个实现类时，像这样按类型注入运行会报错，这是解决办法（再加一个注解）：
    @Autowired//自动装配（自动依赖注入），自动装配的这个对象要么已注解注入，要么已xml注入
    @Qualifier("DeptDao1")
    private DeptDao deptDao;//这个依赖bean会被延迟注入
    @Override
    public void save() {
        deptDao.add();
    }
}
