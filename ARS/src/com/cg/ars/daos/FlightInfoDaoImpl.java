package com.cg.ars.daos;


import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.ars.dtos.FlightInfoBean;
import com.cg.ars.exceptions.AirlineException;

@Repository
public class FlightInfoDaoImpl implements FlightInfoDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean createNewFlight(FlightInfoBean flightBean)
			throws AirlineException {
		
		try {
			manager.persist(flightBean);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public ArrayList<FlightInfoBean> getFlightList(String depCity,
			String arrCity, Date depDate) throws AirlineException {
		
		String strQry = "SELECT f FROM FlightInfoBean f WHERE f.depCity=:depCity AND f.arrCity=:arrCity AND f.depDate=:depDate";
		TypedQuery<FlightInfoBean> qry = manager.createQuery(strQry, FlightInfoBean.class);
		qry.setParameter("depCity", depCity);
		qry.setParameter("arrCity", arrCity);
		qry.setParameter("depDate", depDate);
		ArrayList<FlightInfoBean> flightList = (ArrayList<FlightInfoBean>) qry.getResultList();
		return flightList;
	}

	@Override
	public FlightInfoBean getFlightDetailsOnId(int flightNo)
			throws AirlineException {
		
		return manager.find(FlightInfoBean.class, flightNo);
	}

	//ExecutiveService
	@Override
	public ArrayList<FlightInfoBean> getFlightListOnDate(Date startDepDate,
			Date endDepDate) throws AirlineException {
		
		String strQry = "SELECT f FROM FlightInfoBean f WHERE depDate BETWEEN :startDepDate AND :endDepDate";
		TypedQuery<FlightInfoBean> qry = manager.createQuery(strQry, FlightInfoBean.class);
		qry.setParameter("startDepDate", startDepDate);
		qry.setParameter("endDepDate", endDepDate);
		ArrayList<FlightInfoBean> flightListOnDate = (ArrayList<FlightInfoBean>) qry.getResultList();
		return flightListOnDate;
	}

	//CustomerService
	@Override
	public boolean updateSeatsOnBooking(int flightNo, String classType,
			int noOfPassengers) throws AirlineException {
		
		String strQry = null;
		int recAffected = 0;
		
		if("BUSINESS".equals(classType)){
			strQry = "UPDATE FlightInfoBean f SET f.bussSeatsAvailable = f.bussSeatsAvailable-:noOfPassengers WHERE f.flightNo=:flightNo";
		} else if("FIRST".equals(classType)){
			strQry = "UPDATE FlightInfoBean f SET f.firstSeatsAvailable = f.firstSeatsAvailable-:noOfPassengers WHERE f.flightNo=:flightNo";
		}
		
		Query qry = manager.createQuery(strQry);
		qry.setParameter("noOfPassengers", noOfPassengers);
		qry.setParameter("flightNo", flightNo);
		
		recAffected = qry.executeUpdate();
		
		return recAffected==0?false:true;
	}

	//CustomerService
	@Override
	public boolean updateSeatsOnCancellation(int flightNo, String classType,
			int noOfPassengers) throws AirlineException {
		
		String strQry = null;
		int recAffected = 0;
		
		if("BUSINESS".equals(classType)){
			strQry = "UPDATE FlightInfoBean f SET f.bussSeatsAvailable = f.bussSeatsAvailable+:noOfPassengers WHERE f.flightNo=:flightNo";
		} else if("FIRST".equals(classType)){
			strQry = "UPDATE FlightInfoBean f SET f.firstSeatsAvailable = f.firstSeatsAvailable+:noOfPassengers WHERE f.flightNo=:flightNo";
		}
		
		Query qry = manager.createQuery(strQry);
		qry.setParameter("noOfPassengers", noOfPassengers);
		qry.setParameter("flightNo", flightNo);
		
		recAffected = qry.executeUpdate();
		
		return recAffected==0?false:true;
	}

	//AdminService
	@Override
	public boolean removeFlight(int flightNo) throws AirlineException {
		
		FlightInfoBean flightBean = manager.find(FlightInfoBean.class, flightNo);
		try {
			manager.remove(flightBean);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	//AdminService
	@Override
	public boolean updateFlightDetails(FlightInfoBean flightBean)
			throws AirlineException {
		
		try {
			manager.merge(flightBean);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	//CustomerService
	@Override
	public ArrayList<String> getArrCityList() throws AirlineException {
		
		String strQry = "SELECT DISTINCT f.arrCity FROM FlightInfoBean f";
		TypedQuery<String> qry = manager.createQuery(strQry, String.class);
		ArrayList<String> arrCityList = (ArrayList<String>) qry.getResultList();
		return arrCityList;
	}

	//CustomerService
	@Override
	public ArrayList<String> getDepCityList() throws AirlineException {
		
		String strQry = "SELECT DISTINCT f.depCity FROM FlightInfoBean f";
		TypedQuery<String> qry = manager.createQuery(strQry, String.class);
		ArrayList<String> depCityList = (ArrayList<String>) qry.getResultList();
		return depCityList;
	}

}
