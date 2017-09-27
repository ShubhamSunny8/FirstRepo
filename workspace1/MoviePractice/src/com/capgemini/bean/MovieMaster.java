package com.capgemini.bean;

public class MovieMaster {

	public MovieMaster() {
		// TODO Auto-generated constructor stub
	}
	String movie_id ;
	String movie_name;
	String theatre_name;
	String theatre_location;
	String city ;
	String show_timing;
	String status;
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getTheatre_name() {
		return theatre_name;
	}
	public void setTheatre_name(String theatre_name) {
		this.theatre_name = theatre_name;
	}
	public String getTheatre_location() {
		return theatre_location;
	}
	public void setTheatre_location(String theatre_location) {
		this.theatre_location = theatre_location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getShow_timing() {
		return show_timing;
	}
	public void setShow_timing(String show_timing) {
		this.show_timing = show_timing;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MovieMaster(String movie_id, String movie_name, String theatre_name,
			String theatre_location, String city, String show_timing,
			String status) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.theatre_name = theatre_name;
		this.theatre_location = theatre_location;
		this.city = city;
		this.show_timing = show_timing;
		this.status = status;
	}
	@Override
	public String toString() {
		return "MovieMaster [movie_id=" + movie_id + ", movie_name="
				+ movie_name + ", theatre_name=" + theatre_name
				+ ", theatre_location=" + theatre_location + ", city=" + city
				+ ", show_timing=" + show_timing + ", status=" + status + "]";
	}
	
}
