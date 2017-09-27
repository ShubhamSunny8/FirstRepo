package com.cg.hr.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.hr.dao.EmpDao;
import com.cg.hr.dao.EmpDaoImpl;
import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;


@Service("empServices")
public class EmpServicesImpl implements EmpServices {
	private EmpDao dao;
	public EmpServicesImpl() {
		//
		System.out.println("in Constructor of  EmpServicesImpl");
	}

	
	/*@Autowired
	@Qualifier("empDao")*/
	@Resource
	public void setDao(EmpDao empDao) {
		this.dao = empDao;
		System.out.println("inside set method");
	}

	@Override
	public List<Employee> getAllEmps() throws EmpException {
		System.out.println("In getAllEmps() method of EmpServicesImpl");
		 return dao.getAllEmps();
	}


	@Override
	public Employee getEmpOnId(int id) throws EmpException {
		return dao.getEmpOnId(id);
	}

}
