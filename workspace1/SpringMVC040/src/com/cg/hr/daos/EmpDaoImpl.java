package com.cg.hr.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.hr.dto.Employee;
import com.cg.hr.exception.EmpException;
@Repository
public class EmpDaoImpl implements EmpDao {
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Employee> getEmpList() throws EmpException {
		// TODO Auto-generated method stub
		String strQry="select e from Employee e";
		TypedQuery<Employee> qry=manager.createQuery(strQry,Employee.class);
		List<Employee> empList =qry.getResultList();
		//System.out.println(empList);
		return empList;
	}

	@Override
	public Employee getEmployeeEmpOnId(int empNo) throws EmpException {
		// TODO Auto-generated method stub
		Employee emp=manager.find(Employee.class, empNo);
		return emp;
	}

	@Override
	public void insertNewEmployee(Employee emp) throws EmpException {
		// TODO Auto-generated method stub
		manager.persist(emp);
		
	}
	public List<Integer> getEmpNoList() throws EmpException {
		// TODO Auto-generated method stub
		String strQry="select e.empNo from Employee e";
		TypedQuery<Integer> qry=manager.createQuery(strQry,Integer.class);
		List<Integer> empNoList =qry.getResultList();
		//System.out.println(empList);
		return empNoList;
	}
	
	
	@Override
	public void updateEmployee(int empNO, String empNm) throws EmpException {
		// TODO Auto-generated method stub
		
		Employee emp=manager.find(Employee.class, empNO);
		emp.setEmpNm(empNm);
	}

	@Override
	public void deleteEmployee(int empNo) throws EmpException {
		Employee emp1=manager.find(Employee.class, empNo);
		manager.remove(emp1);	
	}

}
