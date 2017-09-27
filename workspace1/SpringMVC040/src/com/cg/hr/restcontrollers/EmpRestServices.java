package com.cg.hr.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hr.dto.Employee;
import com.cg.hr.exception.EmpException;
import com.cg.hr.services.EmpServices;
//http://localhost:8088/SpringMVC040/rest/empList
//http://localhost:8088/SpringMVC040/rest//empDetails/7788
@RestController
public class EmpRestServices {
	@Autowired
	private EmpServices services;
	@RequestMapping(value="/empList",method=RequestMethod.GET)
	public List<Employee> getEmpList() throws EmpException{
		List<Employee> empList =services.getEmpList();
		System.out.println(empList);
		return empList;
	}
	@RequestMapping(value="/empDetails/{id}",method=RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable("id") int empNo) throws EmpException
	{
		Employee emp= services.getEmployeeEmpOnId(empNo);
		return emp;
		
	}
	@RequestMapping(value="/empDelete/{id}",method=RequestMethod.GET)
	public String empDelete(@PathVariable("id") int empNo) throws EmpException
	{
		System.out.println(empNo);
		services.deleteEmployee(empNo);
		return "Employee removed";
		
		
	}
	
}
