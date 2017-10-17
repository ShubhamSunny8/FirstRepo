
i.	Users
===============================================================================

DROP TABLE users;

CREATE TABLE users(
firstName varchar2(20),
lastName varchar2(20),
userName varchar2(20) primary key, 
password varchar2(20), 
role varchar2(10)
);


ii.	Airport:
===============================================================================

DROP TABLE airport;

CREATE TABLE airport(
airportName varchar2(80), 
abbreviation varchar2(5), 
location varchar2(40)
);


iii.	FlightInformation:
===============================================================================

DROP TABLE flightInfo;

CREATE TABLE flightInfo(
flightNo number(5) primary key, 
airline varchar2(20), 
depCity varchar2(20), 
arrCity varchar2(20), 
depDate date,
arrDate date, 
depTime varchar2(20), 
arrTime varchar2(20), 
firstSeats number, 
firstSeatsAvailable number,
firstSeatFare number(10,2),
bussSeats number, 
bussSeatsAvailable number,
bussSeatFare number(10,2)
);



iv.	BookingInformation:
===============================================================================

DROP TABLE BookingInfo;

CREATE TABLE bookingInfo(
BookingId number(5) primary key,
flightNo number(5), 
custEmail varchar2(20),
noOfPassengers number, 
classType varchar2(10),
depDate date,
arrDate date, 
depTime varchar2(20), 
arrTime varchar2(20),
totalFare number(10,2), 
CreditCardInfo varchar2(20), 
srcCity varchar2(20), 
destCity varchar2(20),
userName varchar2(20)
);


===============================================================================
DROP Sequence autoBookingId;

Create sequence autoBookingId start with 1000;

