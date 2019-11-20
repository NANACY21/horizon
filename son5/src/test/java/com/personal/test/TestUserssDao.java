package com.personal.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.personal.dao.UserssDao;
import com.personal.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})

public class TestUserssDao {
	
	@Autowired
	private UserssDao userssDao;

	@Test
	@Transactional
	@Rollback(false)
	public void test1() {

		User user = new User();
		user.setUsername("hola555la");
		user.setAge(12);
		userssDao.save(user);
	}

	/**
	 * 批量增加
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test2() {

		User user1 = new User();
		user1.setUsername("hola666la1");
		user1.setAge(121);

		User user2 = new User();
		user2.setUsername("hola777la2");
		user2.setAge(122);

		User user3 = new User();
		user3.setUsername("hol888ala3");
		user3.setAge(123);

		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		userssDao.saveAll(users);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test3() {
		Optional<User> ops = userssDao.findById(4);
		User user = ops.get();
		System.out.println(user);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test4() {

		List<User> users = (List<User>) userssDao.findAll();
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test5() {

		userssDao.deleteById(7);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test6() {

		User user = userssDao.findById(6).get();
		user.setUsername("lllllll");
		//userssDao.save(user);//这没有必要，因为是持久化状态，其pojo属性改变直接影响db
	}
}
