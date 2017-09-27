package com.capgemini.dto;

public class User {
	private String name;
	private int num;
	
	public User(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", num=" + num + "]";
	}
	

}
