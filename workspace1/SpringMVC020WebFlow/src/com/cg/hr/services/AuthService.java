package com.cg.hr.services;

import com.cg.hr.entities.User;
import com.cg.hr.exception.EmpException;

public interface AuthService {
	public User isAuthenticated(User user) throws EmpException; 
}
