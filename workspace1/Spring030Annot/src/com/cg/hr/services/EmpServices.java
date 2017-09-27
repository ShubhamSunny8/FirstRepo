package com.cg.hr.services;

import java.util.List;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;

public interface EmpServices {
	List<Employee> getAllEmps() throws EmpException;
	Employee getEmpOnId(int id) throws EmpException;
}
