package com.cg.hr.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.hr.entities.User;
import com.cg.hr.exception.EmpException;

@Repository
public class UserDaoImp implements UserDao {
	@PersistenceContext
	private EntityManager manager;
	@Override
	public User getUseronUserName(String userName) throws EmpException {
		
		User user=manager.find(User.class, userName);
		return user;
	}

}
