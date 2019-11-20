package com.personal.dao.impl;

import com.personal.dao.DeptDao;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * 该注解（这是注解方式定义bean） <=> 定义一个bean，id：DeptDao1，class：DeptDaoImpl
 * 若接口只有一个实现类，参数可省略，因此一般还是加个参数（bean的id）
 */

//@Component("DeptDao1")
@Lazy//表示这个bean可能会延迟注入
@Repository("DeptDao1")
//@Scope("prototype")//表示每次调用该类会新生成对象，即不是单例了
public class DeptDaoImpl implements DeptDao {

    @Override
    public void add() {
        System.out.println("add dept_1");
    }
}
