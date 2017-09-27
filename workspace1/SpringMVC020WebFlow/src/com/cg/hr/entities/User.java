package com.cg.hr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String fullName;
	private boolean isAuthSucc;
	private String message;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Transient
	public boolean isAuthSucc() {
		return isAuthSucc;
	}
	
	public void setAuthSucc(boolean isAuthSucc) {
		this.isAuthSucc = isAuthSucc;
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	@Id
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Transient
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", fullName=" + fullName + ", message=" + message + "]";
	}
	
	
}
