package com.cg.jpapractice.service;

import com.cg.jpapractice.dao.StudentDao;
import com.cg.jpapractice.dao.StudentDaoImpl;
import com.cg.jpapractice.entities.Student;

public class StudentServiceImp implements StudentService {
	
	
	@Override
	public Student viewStudentById(int id) {
		StudentDao n1=new StudentDaoImpl();
		
		Student s=new Student();
		s=n1.viewStudentById(id);
		return s;
	}

	@Override
	public void addStudent(Student student) {
		StudentDao n1=new StudentDaoImpl();
		n1.beginTransaction();
	 n1.addStudent(student);
	 n1.commitTransaction();
	}

}
