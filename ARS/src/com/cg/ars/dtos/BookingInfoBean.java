package com.cg.ars.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BOOKINGINFO")
public class BookingInfoBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int bookingId;
	private int flightNo;
	private String custEmail;
	private int noOfPassengers;
	private String classType;
	private Date depDate;
	private Date arrDate;
	private String depTime;
	private String arrTime;
	private float totalFare;
	private String creditCardInfo;
	private String srcCity;
	private String destCity;
	private String userName;
	
	//getters-setters
	
	@Id
	@Column(name="BOOKINGID")
	@SequenceGenerator(name="idSeq",sequenceName="autoBookingId",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idSeq")
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	@Column(name="FLIGHTNO")
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	
	@Column(name="CUSTEMAIL")
	public String getCustEmail() {
		return custEmail;
	}
	
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	@Column(name="NOOFPASSENGERS")
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	@Column(name="CLASSTYPE")
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
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
	
	
	
	@Column(name="TOTALFARE")
	public float getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(float totalFare) {
		this.totalFare = totalFare;
	}
	
	@Column(name="CREDITCARDINFO")
	public String getCreditCardInfo() {
		return creditCardInfo;
	}
	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
	
	@Column(name="SRCCITY")
	public String getSrcCity() {
		return srcCity;
	}
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}
	
	@Column(name="DESTCITY")
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	
	
	@Column(name="USERNAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	//default constructor
	public BookingInfoBean() {
		super();
	}
	
	
	
	//parameterized constructor
	public BookingInfoBean(int bookingId, int flightNo, String custEmail,
			int noOfPassengers, String classType, Date depDate,
			Date arrDate, String depTime, String arrTime, float totalFare,
			String creditCardInfo, String srcCity, String destCity,
			String userName) {
		super();
		this.bookingId = bookingId;
		this.flightNo = flightNo;
		this.custEmail = custEmail;
		this.noOfPassengers = noOfPassengers;
		this.classType = classType;
		this.depDate = depDate;
		this.arrDate = arrDate;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.totalFare = totalFare;
		this.creditCardInfo = creditCardInfo;
		this.srcCity = srcCity;
		this.destCity = destCity;
		this.userName = userName;
	}
	
	
	//to String method
	@Override
	public String toString() {
		return "BookingInfoBean [bookingId=" + bookingId + ", flightNo="
				+ flightNo + ", custEmail=" + custEmail + ", noOfPassengers="
				+ noOfPassengers + ", classType=" + classType + ", depDate="
				+ depDate + ", arrDate=" + arrDate + ", depTime=" + depTime
				+ ", arrTime=" + arrTime + ", totalFare=" + totalFare
				+ ", creditCardInfo=" + creditCardInfo + ", srcCity=" + srcCity
				+ ", destCity=" + destCity + ", userName=" + userName + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
