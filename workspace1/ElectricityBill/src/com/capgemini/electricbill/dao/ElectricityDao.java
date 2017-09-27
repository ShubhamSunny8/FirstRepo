package com.capgemini.electricbill.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.capgemini.electricbill.bean.Customer;
import com.capgemini.electricbill.exception.Electricbillexception;



public interface ElectricityDao {
	public ArrayList viewList() throws  Electricbillexception, SQLException, NamingException;
	public Customer getCustomerbyId(int id) throws Electricbillexception, SQLException, NamingException;
}
