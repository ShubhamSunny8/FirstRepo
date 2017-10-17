package com.cg.ars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.ars.daos.FlightInfoDao;
import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

@Service
@Transactional
public class ExecutiveServiceImpl implements ExecutiveService{

	@Resource
	private FlightInfoDao flightInfoDao;
	
	//FlightInfoDao
	@Override
	public FlightInfoBean viewFlightOccupancyOnId(int flightNo)
			throws AirlineException {
		
		FlightInfoBean flightBean = flightInfoDao.getFlightDetailsOnId(flightNo);
		
		return flightBean;
	}

	//FlightInfoDao
	@Override
	public ArrayList<FlightInfoBean> viewFlightOccupancyOnDate(Date startDepDate, Date endDepDate)
											throws AirlineException {
		
		ArrayList<FlightInfoBean> flightList = flightInfoDao.getFlightListOnDate(startDepDate, endDepDate);
		
		return flightList;
	}

	
	
}
