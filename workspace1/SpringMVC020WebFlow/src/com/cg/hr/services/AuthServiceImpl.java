package com.cg.hr.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cg.hr.daos.UserDao;
import com.cg.hr.entities.User;
import com.cg.hr.exception.EmpException;
@Service
public class AuthServiceImpl implements AuthService {
	private UserDao dao;
	


	@Resource
	public void setDao(UserDao dao) {
		this.dao = dao;
	}



	@Override
	public User isAuthenticated(User userForm) throws EmpException {
		System.out.println("In Service"+userForm);
		User userDb=dao.getUseronUserName(userForm.getUserName());
		
		if(userDb==null)
		{
			userForm.setMessage("UserName does not exists");
			userForm.setAuthSucc(false);
		}else{
			if(userForm.getPassword().equals(userDb.getPassword())){
				userForm.setAuthSucc(true);
				userForm.setFullName(userDb.getFullName());
			}else{
				userForm.setMessage("Password Mismatch");
				userForm.setAuthSucc(false);
			}
		}
		
		
		return userForm;
	}
}
