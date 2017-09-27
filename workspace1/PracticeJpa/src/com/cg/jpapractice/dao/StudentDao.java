package com.cg.jpapractice.dao;

import com.cg.jpapractice.entities.Student;



public interface StudentDao {
	public abstract Student viewStudentById(int id);

	public abstract void addStudent(Student student);
	public abstract void commitTransaction();
	public abstract void beginTransaction();
}
