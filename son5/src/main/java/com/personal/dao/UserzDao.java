package com.personal.dao;

import com.personal.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 功能最全的接口
 */
public interface UserzDao extends JpaRepository<User, Integer> {

    //注意方法命名规范
    List<User> findByUsername(String username);

    @Query("from User where age=:age")
    List<User> getUserAge(@Param("age") int age);


    @Query(value = "select * from users", nativeQuery = true)
    List<User> getUsers();
}
