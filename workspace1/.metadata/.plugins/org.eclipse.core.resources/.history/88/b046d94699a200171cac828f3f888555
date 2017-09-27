package com.cg.hr.dto;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;

@Entity
@Table(name="EMP")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String empNm;
	
	private float empSal;
	private Date hireDate;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empNo, String empNm) {
		super();
		this.empNo = empNo;
		this.empNm = empNm;
	}
	@Generated(srategy=Generation Type.Auto)
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empNm=" + empNm + "]";
	}
	
	
}
