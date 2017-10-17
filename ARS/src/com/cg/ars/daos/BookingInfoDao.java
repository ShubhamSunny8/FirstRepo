package com.cg.ars.daos;

import java.util.ArrayList;

import com.cg.ars.dtos.BookingInfoBean;
import com.cg.ars.exceptions.AirlineException;

public interface BookingInfoDao {

	//userService	
	public int createNewBooking(BookingInfoBean bookingInfoBean) throws AirlineException;
	
	//userService
	public BookingInfoBean getBookingOnId(int bookingId, String userName) throws AirlineException; 
	
	//userService
	public boolean removeBookingOnId(int bookingId) throws AirlineException;
	
	//adminService
	public ArrayList<BookingInfoBean> getBookingListOnFlightNo(int flightNo) throws AirlineException;

	
}
