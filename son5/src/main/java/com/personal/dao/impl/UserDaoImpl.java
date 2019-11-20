package com.personal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.dao.UserDao;
import com.personal.pojo.User;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private EntityManager em;//类似sqlSession
	@Override
	public int save(User user) {
		 em.persist(user);//insert 
		 return 0;
	}
	@Override
	public void deleteUserById(int id) {
		User user = em.find(User.class, id);//select 
		em.remove(user);//delete
		
	}
	@Override
	public void updateUser(User user) {
		User u = em.find(User.class, user.getId());
		u.setUsername(user.getUsername());
		u.setAge(user.getAge());
		//em.merge(u);//新建 持久化 游离
	}
	@Override
	public User getUserById(int id) {
		User user = em.find(User.class, id);
		return user;
	}
	@Override
	public List<User> getUsers() {
		List<User> users = em.createQuery("from User u").getResultList();
		return users;
	}
}
