package com.cg.hr.test;

import java.util.List;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.hr.entities.Employee;
import com.cg.hr.exceptions.EmpException;
import com.cg.hr.services.EmpServices;
import com.cg.hr.services.EmpServicesImpl;

public class TestDI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	EmpServices services=new EmpServicesImpl();
		System.out.println("Object Created");*/
		System.out.println("1. for viewing all employees");
		System.out.println("2. for finding  a particular  employee");
		Scanner sc = new Scanner(System.in);
		int choice=Integer.parseInt(sc.next());
		switch(choice){
		case 1:
			ApplicationContext ctx= new ClassPathXmlApplicationContext("EmpManagement.xml");
			EmpServices services =(EmpServices)ctx.getBean("empServices");
			try {
				List<Employee> empList =services.getAllEmps();
				empList=services.getAllEmps();
				for (Employee employee : empList) {
					System.out.println(employee+"\n");
				}
				
			} catch (EmpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		case 2:
			System.out.println("enter the employee id");
			int id= sc.nextInt();
			
			ApplicationContext ctx1= new ClassPathXmlApplicationContext("EmpManagement.xml");
			EmpServices services1 =(EmpServices)ctx1.getBean("empServices");
			try {
				System.out.println(services1.getEmpOnId(id));
			} catch (EmpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;

	}
	}

}
