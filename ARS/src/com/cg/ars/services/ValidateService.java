package com.cg.ars.services;

import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface ValidateService {

	//UsersDao
	public boolean validateUser(UsersBean usersBean) throws AirlineException;
	
	//FlightInfoDao
	public boolean validateFlightNo(int flightNo) throws AirlineException;
	
	public boolean validateUserName(String userName) throws AirlineException;
	
}
