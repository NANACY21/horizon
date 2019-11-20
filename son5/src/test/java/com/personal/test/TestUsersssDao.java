package com.personal.test;

import com.personal.dao.UsersssDao;
import com.personal.dao.UserzDao;
import com.personal.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class TestUsersssDao {
    @Autowired
    UsersssDao usersssDao;

    @Autowired
    UserzDao userzDao;

    JpaSpecificationExecutor sss = null;//Repository体系外的接口
    /**
     * 分页示例
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test1() {
        //参数：当前页索引，每页几行
        Pageable pageable = PageRequest.of(0, 2);
        Page<User> page = usersssDao.findAll(pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总行数："+page.getTotalElements());
        List<User> content = page.getContent();

        for (User user : content) {
            System.out.println(user);
        }



    }

    /**
     * 排序示例 单列排序
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test2() {
        System.out.println("ooopp");
        //id降序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> all = (List<User>) usersssDao.findAll(sort);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 排序示例 多列排序
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test3() {

        //其次按id降序
        Sort.Order o1 = new Sort.Order(Sort.Direction.DESC, "is");
        //首先按age升序
        Sort.Order o2 = new Sort.Order(Sort.Direction.ASC, "age");

        Sort sort = Sort.by(o2, o1);//先按o2，再按o1
        List<User> all = (List<User>) usersssDao.findAll(sort);
        for (User user : all) {
            System.out.println(user);
        }
    }


    /**
     *
     */
    @Test
    @Transactional
    @Rollback(false)
    public void test4() {
        //查询结果按id降序排序
        List<User> all = userzDao.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (User user : all) {
            System.out.println(user);
        }
    }


    @Test
    @Transactional
    @Rollback(false)
    public void test5() {

        List<User> all = userzDao.findByUsername("admin");
        for (User user : all) {
            System.out.println(user);
        }
    }
}
