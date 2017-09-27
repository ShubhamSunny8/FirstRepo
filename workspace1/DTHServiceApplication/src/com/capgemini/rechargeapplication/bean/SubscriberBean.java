package com.capgemini.rechargeapplication.bean;

import java.time.LocalDate;

public class SubscriberBean {
	private long subscriberId;
	private long mobileNumber;
	private String packageId;
	private float accountBalance;
	private LocalDate rechargeDate;
	
	public SubscriberBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubscriberBean(long subscriberId, long mobileNumber,
			String packageId, float accountBalance, LocalDate rechargeDate) {
		super();
		this.subscriberId = subscriberId;
		this.mobileNumber = mobileNumber;
		this.packageId = packageId;
		this.accountBalance = accountBalance;
		this.rechargeDate = rechargeDate;
	}
	@Override
	public String toString() {
		return "SubscriberBean [subscriberId=" + subscriberId
				+ ", mobileNumber=" + mobileNumber + ", packageId=" + packageId
				+ ", accountBalance=" + accountBalance + ", rechargeDate="
				+ rechargeDate + "]";
	}
	public long getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public LocalDate getRechargeDate() {
		return rechargeDate;
	}
	public void setRechargeDate(LocalDate rechargeDate) {
		this.rechargeDate = rechargeDate;
	}
	


	
}
