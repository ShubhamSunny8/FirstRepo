package com.cg.hr.services;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.hr.daos.EmpDao;
import com.cg.hr.dto.Employee;
import com.cg.hr.exception.EmpException;
@Service
@Transactional
public class EmpServiceImp implements EmpServices {
	@Resource
	private EmpDao dao;
	@Override
	public List<Employee> getEmpList() throws EmpException {
		// TODO Auto-generated method stub
		return dao.getEmpList();
	}
	@Override
	public Employee getEmployeeEmpOnId(int empNo) throws EmpException {
		// TODO Auto-generated method stub
		return dao.getEmployeeEmpOnId(empNo);
	}
	@Override
	public void insertNewEmployee(Employee emp) throws EmpException {
		// TODO Auto-generated method stub
		dao.insertNewEmployee(emp);
		
	}
	@Override
	public void updateEmployee(int empNO, String empNm) throws EmpException {
		// TODO Auto-generated method stub
		 dao.updateEmployee(empNO, empNm);
	}
	@Override
	public List<Integer> getEmpNoList() throws EmpException {
		// TODO Auto-generated method stub
		return dao.getEmpNoList();
	}

}
