package com.cg.movieticket.bean;

public class Ticket {

	private String movieId;
	private String movieName;
	private String theatreName;
	private String theatreLocation;
	private String city;
	private String showTiming;
	private String status;
	
	
	
	
	@Override
	public String toString() {
		return "Ticket [movieId=" + movieId + ", movieName=" + movieName
				+ ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", city=" + city + ", showTiming="
				+ showTiming + ", status=" + status + "]";
	}



	public Ticket() {
		super();
	}



	public Ticket(String movieId, String movieName, String theatreName,
			String theatreLocation, String city, String showTiming,
			String status) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.city = city;
		this.showTiming = showTiming;
		this.status = status;
	}



	public String getMovieId() {
		return movieId;
	}



	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}



	public String getMovieName() {
		return movieName;
	}



	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	public String getTheatreName() {
		return theatreName;
	}



	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}



	public String getTheatreLocation() {
		return theatreLocation;
	}



	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getShowTiming() {
		return showTiming;
	}



	public void setShowTiming(String showTiming) {
		this.showTiming = showTiming;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
