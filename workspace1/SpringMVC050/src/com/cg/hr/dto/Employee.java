package com.cg.hr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="EMP")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String empNm;
	private String email;
	

	private float empSal;
	
	private Date hireDate;
	
	
	
	
	@Transient
	@NotEmpty(message="email not coorect or empty")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="sal")
	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	@Column(name="hiredate")
	@Temporal(TemporalType.DATE)
	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empNo, String empNm) {
		super();
		this.empNo = empNo;
		this.empNm = empNm;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	@NotEmpty(message="Name can Not be empty Sorry !!  Try Again")
	@Size(min=3,max=15,message="Name Size not in limit of 3 to 15 characters")
	@Column(name="ename")
	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empNm=" + empNm + ", empSal="
				+ empSal + ", hireDate=" + hireDate + "]";
	}

	
	
	
}
