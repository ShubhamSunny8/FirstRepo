package com.cg.hr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;
@Repository
public class EmpDaoImpl1 implements EmpDao {

	@Override
	public List<Employee> getAllEmps() throws EmpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmpOnId(int id) throws EmpException {
		// TODO Auto-generated method stub
		return null;
	}

}
