package com.cg.hr.daos;

import java.util.List;

import com.cg.hr.dto.Employee;
import com.cg.hr.exception.EmpException;

public interface EmpDao {
	List <Employee> getEmpList() throws EmpException;
	public void insertNewEmployee(Employee emp) throws EmpException;
	Employee getEmployeeEmpOnId(int empNo) throws EmpException;
	public List<Integer> getEmpNoList() throws EmpException;
	void updateEmployee(int empNO,String empNm) throws EmpException;
}
