package com.personal.service.impl;

import com.personal.dao.NUserDao;
import com.personal.pojo.NUser;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务处理一定在业务层，要么同时成功，要么同时失败
 * 一个事务->要么同时成功，要么同时失败
 */
@Service
//@Transactional//表示该类所有方法都在事务中运行
public class UserServiceImpl implements UserService {
    @Autowired
    private NUserDao nUserDao;
    @Override
    public void saveUser() {
        System.out.println("save user");
    }

    @Override
    public void saveUser(String info) {
        System.out.println("save user" + info);
    }

    // STOPSHIP: 2019/8/16
    @Override
    //该事务传播行为表示：如果该方法在一个事务中执行，纳入那个事务；否则开启一个事务，即该方法就是一个事务，要么同时成功，要么同时失败；出现异常-》回滚
    //事务四种隔离级别：
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = {"java.lang.Exception"})
    public int saveNUser(String nickname, String password) {
//        System.out.println(1/0);
        return nUserDao.addNUser(nickname, password);
    }

    // STOPSHIP: 2019/8/16
    @Override
    @Transactional(readOnly = true)//会覆盖class上的注解
    public NUser getNUser(long uID) {
        return nUserDao.getNUserByUID(uID);
    }

    @Override
    public void saveUser_1() {
        System.out.println("save user_1");
    }

    @Override
    public void delUser() {
        System.out.println("del user");
    }

    @Override
    public void addA() {
        System.out.println("add a");
    }

    @Override
    public void addA(String username) {
        System.out.println("add a" + username);
    }

    @Override
    public void addA(String username, String password) {
        System.out.println("add a" + username + "\t" + password);
    }
}
