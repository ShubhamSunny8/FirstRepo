package com.capgemini.rechargeapplication.exception;

/**
 * Author 		: CAPGEMINI 
 * Class Name 	: DonorTransactionException 
 * Package 		: com.capgemini.donorapplication.exception
 * Date 		: Nov 21, 2016
 */

@SuppressWarnings("serial")
public class RechargeException extends Exception{
	public RechargeException(String message)
	{
		super(message);
	}
}
