package com.capgemini.rechargeapplication.service;


import com.capgemini.rechargeapplication.bean.SubscriberBean;
import com.capgemini.rechargeapplication.dao.ISubscriberDao;
import com.capgemini.rechargeapplication.dao.SubscriberDao;
import com.capgemini.rechargeapplication.exception.RechargeException;


 
public class SubscriberService implements ISubscriberService {
	ISubscriberDao dao;
	
	private static String contactPattern = "[7-9][0-9]{9}";
	private static String amountPattern = "[1-9][0-9]{2,}";
	
	public SubscriberService(){
		super();
		dao = new SubscriberDao();
	}
	
	public static boolean validatePhoneNumber(String phoneNumber){
		boolean flag = false;
		if(phoneNumber.matches(contactPattern))
		{
			flag = true;
		}
		return flag;
	}
	
	public static boolean validateAmount(String amount){
		boolean flag = false;
		if(amount.matches(amountPattern))
		{
			flag = true;
		}
		return flag;
	}

	@Override
	public SubscriberBean getAccountDetails(long mobileNumber)
			throws RechargeException {
		// TODO Auto-generated method stub
		return dao.getAccountDetails(mobileNumber);
	}

	@Override
	public boolean updateAccountDetails(long subscriberId,float updatedAmount) throws RechargeException {
		// TODO Auto-generated method stub
		return dao.updateAccountDetails(subscriberId, updatedAmount);
	}

	@Override
	public float getPackageAmount(String packageId) throws RechargeException {
		// TODO Auto-generated method stub
		return dao.getPackageAmount(packageId);
	}
	
	

}
