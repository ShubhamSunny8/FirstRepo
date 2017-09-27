package com.capgemini.dto;

public class RechargeDAO {
	private int rid;
	private String rechargename;
	private int amount;
	private int validity;
	public RechargeDAO()
	{
		
	}
	public RechargeDAO(int rid, String rechargename, int amount, int validity) {
		super();
		this.rid = rid;
		this.rechargename = rechargename;
		this.amount = amount;
		this.validity = validity;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRechargename() {
		return rechargename;
	}
	public void setRechargename(String rechargename) {
		this.rechargename = rechargename;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	@Override
	public String toString() {
		return "RechargeDAO [rid=" + rid + ", rechargename=" + rechargename
				+ ", amount=" + amount + ", validity=" + validity + "]";
	}
	
	
}
