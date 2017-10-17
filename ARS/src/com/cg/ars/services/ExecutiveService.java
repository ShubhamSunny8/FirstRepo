package com.cg.ars.services;

import java.util.ArrayList;
import java.util.Date;

import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

public interface ExecutiveService {

	//flightInfoDao
	public FlightInfoBean viewFlightOccupancyOnId(int flightNo) 
										throws AirlineException;
	
	//flightInfodao
	public ArrayList<FlightInfoBean> viewFlightOccupancyOnDate(Date startDepDate, Date endDepDate) 
										throws AirlineException;
	
}
