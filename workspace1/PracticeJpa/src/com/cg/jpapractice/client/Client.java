package com.cg.jpapractice.client;

import java.util.Scanner;

import com.cg.jpapractice.entities.Student;
import com.cg.jpapractice.service.StudentService;
import com.cg.jpapractice.service.StudentServiceImp;

public class Client {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentService service = new StudentServiceImp();
		System.out.println("Welcome to Student Service");
		System.out.println("enter your choice:");
		System.out.println("input 1 for adding a student to database");
		System.out.println("input 2 for display of students");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			Student a=new Student();
			System.out.println("enter the Fisrtname");
			a.setFirstname(sc.next());
			//sc.next();
			System.out.println("enter the last name");
			a.setLastname(sc.next());
			//sc.next();
			System.out.println("enter the Standard");
			a.setStandard(sc.nextInt());
			//sc.next();
		
			System.out.println("enter the Rollno");
			a.setRollno(sc.nextInt());
			
			service.addStudent(a);
			break;
		case 2:
			System.out.println("enter the Id of the student to be searched");
			int id=sc.nextInt();
			service.viewStudentById(id);
			break;
		
		}
	}
}
