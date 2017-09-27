package com.cg.hr.services;

import java.util.List;

import com.cg.hr.dao.EmpDao;
import com.cg.hr.dao.EmpDaoImpl;
import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;

public class EmpServicesImpl implements EmpServices {
	private EmpDao dao;
	public EmpServicesImpl() {
		//
		System.out.println("in Constructor of  EmpServicesImpl");
	}

	

	public void setDao(EmpDao dao) {
		this.dao = dao;
		System.out.println("inside set method");
	}

	@Override
	public List<Employee> getAllEmps() throws EmpException {
		System.out.println("In getAllEmps() method of EmpServicesImpl");
		 return dao.getAllEmps();
	}

}
