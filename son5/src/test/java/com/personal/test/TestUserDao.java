package com.personal.test;

import java.util.List;

import com.personal.dao.UserDao;
import com.personal.dao.UsersDao;
import com.personal.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})

public class TestUserDao {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UsersDao usersDao;

	/**
	 * 运行会正向生成表
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void test1() {
		User user = new User();
		user.setUsername("haha33");
		user.setAge(18);
		userDao.save(user);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test2() {
		User user = userDao.getUserById(2);
		System.out.println(user);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test3() {
		userDao.deleteUserById(1);
	}


	@Test
	@Transactional
	@Rollback(false)
	public void test4() {
		User user = new User();
		user.setId(2);
		user.setUsername("admin");
		user.setAge(21);
		userDao.updateUser(user);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test5() {
		List<User> users = userDao.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test6() {
		List<User> users = usersDao.findByUsernameIs("admin");//查不到 不报错
		if (users != null) {
			System.out.println("6797");
		}
		for (User u : users) {
			System.out.println(u);

		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test7() {
		List<User> users = usersDao.findByUsernameLike("%%");
		System.out.println(users.size() + "-----------------");
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test8() {
		List<User> users = usersDao.getUsersByNameAndAge("admin", 21);

		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void test9() {
		List<User> users = usersDao.queryUsers("admin");

		for (User u : users) {
			System.out.println(u);
		}
	}
}