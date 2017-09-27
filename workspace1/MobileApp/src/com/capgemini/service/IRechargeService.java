package com.capgemini.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.capgemini.dto.User;
import com.capgemini.exception.MobileException;

public interface IRechargeService {
	public ArrayList viewList() throws MobileException, SQLException, NamingException;
	public void addRecharge(User u) throws MobileException, NamingException, SQLException;
}
