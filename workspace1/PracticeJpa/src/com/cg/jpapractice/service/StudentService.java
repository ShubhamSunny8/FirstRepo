package com.cg.jpapractice.service;

import com.cg.jpapractice.entities.Student;

public interface StudentService {
	public abstract Student viewStudentById(int id);
	public abstract void addStudent(Student student);
}
