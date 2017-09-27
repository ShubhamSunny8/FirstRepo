package com.capgemini.dth.bean;

import java.util.Date;

public class Customer {
 private long num;
 private String mobno;
 private String pid;
 private float  balance;
 private Date date;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public long getNum() {
	return num;
}
public void setNum(long num) {
	this.num = num;
}
public String getMobno() {
	return mobno;
}
public void setMobno(String mobno) {
	this.mobno = mobno;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Customer [num=" + num + ", mobno=" + mobno + ", pid=" + pid
			+ ", balance=" + balance + ", date=" + date + "]";
}
public Customer(long num, String mobno, String pid, float balance, Date date) {
	super();
	this.num = num;
	this.mobno = mobno;
	this.pid = pid;
	this.balance = balance;
	this.date = date;
}


}
