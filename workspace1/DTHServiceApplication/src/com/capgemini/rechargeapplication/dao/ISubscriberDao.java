package com.capgemini.rechargeapplication.dao;

import com.capgemini.rechargeapplication.bean.SubscriberBean;
import com.capgemini.rechargeapplication.exception.RechargeException;

public interface ISubscriberDao {
	public SubscriberBean getAccountDetails(long mobileNumber) throws RechargeException;
	boolean updateAccountDetails(long subscriberId, float updatedAmount) throws RechargeException;
	public float getPackageAmount(String packageId) throws RechargeException;
}
