package com.capgemini.rechargeapplication.service;

import com.capgemini.rechargeapplication.bean.SubscriberBean;
import com.capgemini.rechargeapplication.exception.RechargeException;

public interface ISubscriberService {
	public SubscriberBean getAccountDetails(long mobileNumber) throws RechargeException;
	public boolean updateAccountDetails(long subscriberId, float updatedAmount) throws RechargeException;
	public float getPackageAmount(String packageId) throws RechargeException;
}
