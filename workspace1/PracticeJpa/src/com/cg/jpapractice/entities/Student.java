package com.cg.jpapractice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private String Firstname;
	private String Lastname;
	private int standard;
	private int rollno;
	 
	public Student( String firstname, String lastname,
			int standard, int rollno) {
		super();
		
		Firstname = firstname;
		Lastname = lastname;
		this.standard = standard;
		this.rollno = rollno;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", Firstname=" + Firstname
				+ ", Lastname=" + Lastname + ", standard=" + standard
				+ ", rollno=" + rollno + "]";
	}
	
 
}
