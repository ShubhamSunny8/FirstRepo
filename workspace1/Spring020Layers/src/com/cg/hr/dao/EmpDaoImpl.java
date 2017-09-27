package com.cg.hr.dao;

import java.util.List;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;

public class EmpDaoImpl implements EmpDao {

	
	
	public EmpDaoImpl() {
		//procure data source
		System.out.println("in constructor of EmpDao Impl");
	}

	@Override
	public List<Employee> getAllEmps() throws EmpException {
		System.out.println("In getAllEmps() of empDaoImpl");
		return null;
		
	}

}
