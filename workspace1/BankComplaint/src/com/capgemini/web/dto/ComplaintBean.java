package com.capgemini.web.dto;

import java.util.Date;

public class ComplaintBean {
	private int id ;
	private  String customerName ;
	private int accountId;
	private String cateogary ;
	private Date complaintDate ;
	private String description ;
	private String priority ;
	private String status;
	public ComplaintBean() {
	
	}
	public ComplaintBean(String customerName, int accountId, String cateogary,
			String description) {
		super();
		this.customerName = customerName;
		this.accountId = accountId;
		this.cateogary = cateogary;
		this.description = description;
	}
	public ComplaintBean(int id, String customerName, int accountId,
			String cateogary, Date complaintDate, String description,
			String priority, String status) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.accountId = accountId;
		this.cateogary = cateogary;
		this.complaintDate = complaintDate;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getCateogary() {
		return cateogary;
	}
	public void setCateogary(String cateogary) {
		this.cateogary = cateogary;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ComplaintBean [id=" + id + ", customerName=" + customerName
				+ ", accountId=" + accountId + ", cateogary=" + cateogary
				+ ", complaintDate=" + complaintDate + ", description="
				+ description + ", priority=" + priority + ", status=" + status
				+ "]";
	}
	
}
