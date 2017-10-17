package com.cg.ars.dtos;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="FLIGHTINFO")
public class FlightInfoBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int flightNo;
	private String airline;
	private String depCity;
	private String arrCity;
	private Date depDate;
	private Date arrDate;
	private String depTime;
	private String arrTime;
	private int firstSeats;
	private float firstSeatFare;
	private int firstSeatsAvailable;
	private int bussSeats;
	private float bussSeatFare;
	private int bussSeatsAvailable;
	
	//getters-setters
	
	
	@Id
	@Column(name="FLIGHTNO")
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	
	
	
	@Column(name="AIRLINE")
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	
	
	@Column(name="DEPCITY")
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	
	
	
	@Column(name="ARRCITY")
	public String getArrCity() {
		return arrCity;
	}
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	
	
	
	@Column(name="DEPDATE")	
	@Temporal(TemporalType.DATE)
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	
	
	@Column(name="ARRDATE")	
	@Temporal(TemporalType.DATE)
	public Date getArrDate() {
		return arrDate;
	}
	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}
	
	
	@Column(name="DEPTIME")
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	
	
	@Column(name="ARRTIME")
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	
	
	@Column(name="FIRSTSEATS")
	public int getFirstSeats() {
		return firstSeats;
	}
	public void setFirstSeats(int firstSeats) {
		this.firstSeats = firstSeats;
	}
	
	
	@Column(name="FIRSTSEATFARE")
	public float getFirstSeatFare() {
		return firstSeatFare;
	}
	public void setFirstSeatFare(float firstSeatFare) {
		this.firstSeatFare = firstSeatFare;
	}
	
	
	@Column(name="FIRSTSEATSAVAILABLE")
	public int getFirstSeatsAvailable() {
		return firstSeatsAvailable;
	}
	public void setFirstSeatsAvailable(int firstSeatsAvailable) {
		this.firstSeatsAvailable = firstSeatsAvailable;
	}
	
	
	@Column(name="BUSSSEATS")
	public int getBussSeats() {
		return bussSeats;
	}
	public void setBussSeats(int bussSeats) {
		this.bussSeats = bussSeats;
	}
	
	
	@Column(name="BUSSSEATFARE")
	public float getBussSeatFare() {
		return bussSeatFare;
	}
	public void setBussSeatFare(float bussSeatFare) {
		this.bussSeatFare = bussSeatFare;
	}
	
	
	@Column(name="BUSSSEATSAVAILABLE")
	public int getBussSeatsAvailable() {
		return bussSeatsAvailable;
	}
	public void setBussSeatsAvailable(int bussSeatsAvailable) {
		this.bussSeatsAvailable = bussSeatsAvailable;
	}
	
	//parameterized constructor
	public FlightInfoBean(int flightNo, String airline, String depCity,
			String arrCity, Date depDate, Date arrDate,
			String depTime, String arrTime, int firstSeats,
			float firstSeatFare, int firstSeatsAvailable, int bussSeats,
			float bussSeatFare, int bussSeatsAvailable) {
		super();
		this.flightNo = flightNo;
		this.airline = airline;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.depDate = depDate;
		this.arrDate = arrDate;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.firstSeats = firstSeats;
		this.firstSeatFare = firstSeatFare;
		this.firstSeatsAvailable = firstSeatsAvailable;
		this.bussSeats = bussSeats;
		this.bussSeatFare = bussSeatFare;
		this.bussSeatsAvailable = bussSeatsAvailable;
	}
	
	//default constructor
	public FlightInfoBean() {
		super();
	}
	
	
	//To string method
	@Override
	public String toString() {
		return "FlightInfoBean [flightNo=" + flightNo + ", airline=" + airline
				+ ", depCity=" + depCity + ", arrCity=" + arrCity
				+ ", depDate=" + depDate + ", arrDate=" + arrDate
				+ ", depTime=" + depTime + ", arrTime=" + arrTime
				+ ", firstSeats=" + firstSeats + ", firstSeatFare="
				+ firstSeatFare + ", firstSeatsAvailable="
				+ firstSeatsAvailable + ", bussSeats=" + bussSeats
				+ ", bussSeatFare=" + bussSeatFare + ", bussSeatsAvailable="
				+ bussSeatsAvailable + "]";
	}

	
	
	
	
	
	
	
}
