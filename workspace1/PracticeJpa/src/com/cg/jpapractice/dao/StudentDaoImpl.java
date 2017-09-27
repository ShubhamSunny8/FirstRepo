package com.cg.jpapractice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import com.cg.jpapractice.entities.Student;

public class StudentDaoImpl implements StudentDao {
	private EntityManager entityManager;
	
	
	
	public StudentDaoImpl() {
		
		entityManager = JPAUtil.getEntityManager();
	}

	
	@Override
	public Student viewStudentById(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

}
