package com.cg.hr.tests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.hr.dto.Employee;
import com.cg.hr.exception.EmpException;
import com.cg.hr.services.EmpServiceImp;
import com.cg.hr.services.EmpServices;



public class TestLayers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx= new ClassPathXmlApplicationContext();
				EmpServices service=ctx.getBean(EmpServices.class);
		try {
			List<Employee> empList=service.getEmpList();
			System.out.println(empList);
		} catch (EmpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
