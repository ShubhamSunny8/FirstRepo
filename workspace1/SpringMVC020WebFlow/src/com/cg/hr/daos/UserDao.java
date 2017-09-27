package com.cg.hr.daos;

import com.cg.hr.entities.User;
import com.cg.hr.exception.EmpException;

public interface UserDao {
	User getUseronUserName(String userName) throws EmpException;
}
