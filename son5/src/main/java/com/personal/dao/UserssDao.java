package com.personal.dao;

import org.springframework.data.repository.CrudRepository;

import com.personal.pojo.User;

/**
 * 不好使！！！增删改好使 查询不好使！！！！
 */
public interface UserssDao extends CrudRepository<User, Integer> {

}
