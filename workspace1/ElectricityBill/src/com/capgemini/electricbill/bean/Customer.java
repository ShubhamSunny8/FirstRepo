package com.capgemini.electricbill.bean;

public class Customer {
	private int number;
	private String name;
	private String address;
	public Customer(int number, String name, String address) {
		super();
		this.number = number;
		this.name = name;
		this.address = address;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [number=" + number + ", name=" + name + ", address="
				+ address + "]";
	}
	
	
	
}
