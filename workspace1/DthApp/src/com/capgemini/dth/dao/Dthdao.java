package com.capgemini.dth.dao;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.capgemini.dth.bean.Customer;
import com.capgemini.dth.exception.Dthexception;



public interface Dthdao {
	public Customer getCustomerbyId(String id) throws Dthexception, SQLException, NamingException;
	public boolean update(float amount,long id) throws Dthexception, SQLException, NamingException;
}
