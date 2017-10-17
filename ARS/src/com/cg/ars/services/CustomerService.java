package com.cg.ars.services;


import java.util.ArrayList;
import java.util.Date;

import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;

public interface CustomerService {

	//UsersDao
	public boolean addNewCustomer(UsersBean usersBean) throws AirlineException;
	
	//FlightInfoDao
	public ArrayList<String> getDepCityList() throws AirlineException;
	
	//FlightInfoDao
	public ArrayList<String> getArrCityList() throws AirlineException;
	
	//FlightInfoDao
	public ArrayList<FlightInfoBean> viewFlightList(String depCity,String arrCity, Date depDate) 
												throws AirlineException;
	
	//FlightInfoDao
	public FlightInfoBean viewFlightDetailsOnId(int flightNo) 
											throws AirlineException;
	
	//FlightInfoDao
	public float generateTotalFare(int flightNo, String classType, int noOfPassengers)
											throws AirlineException;
	
	//FlightInfoDao and BookingInfoDao
	public int bookFlight(BookingInfoBean bookingBean) throws AirlineException;
	
	//BookingInfoDao
	public BookingInfoBean viewBookingOnId(int bookingId, String userName) throws AirlineException;

	//BookingInfoDao and FlightInfoDao
	public boolean cancelBookingOnId(int bookingId, String userName) throws AirlineException;

}
