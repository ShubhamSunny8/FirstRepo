package com.cg.ars.services;

import java.util.ArrayList;

import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

public interface AdminService {

	//FlightInfoDao
	public boolean createNewFlight(FlightInfoBean flightBean) throws AirlineException;
	
	//FlightInfoDao
	public FlightInfoBean viewFlightDetailsOnId(int flightNo) 
												throws AirlineException;
	
	//BookingInfoDao
	public ArrayList<BookingInfoBean> viewBookingListOnFlightNo(int flightNo) throws AirlineException;
	
	//FlightInfoDao
	public boolean removeFlight(int flightNo) throws AirlineException;
	
	//FlightInfoDao
	public boolean updateFlightDetails(FlightInfoBean flightBean) throws AirlineException;
	
}
