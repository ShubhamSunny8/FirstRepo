package com.cg.ars.daos;

import java.util.ArrayList;

import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface UsersDao {
	
	public boolean addNewCustomer(UsersBean userBean) throws AirlineException;

	public ArrayList<String> getUserNameList() throws AirlineException;
	
	public ArrayList<UsersBean> getUsersList() throws AirlineException;
}
