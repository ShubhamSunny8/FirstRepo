package com.cg.myapp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="trainee")
@Table(name="trainee")
public class Trainee implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int traineeId;
	private String traineeName;
	private String traineeLocation;
	private String traineedomain;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="traineeid")
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	@Column(name="traineename")
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	@Column(name="traineelocation")
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	@Column(name="traineedomain")
	public String getTraineedomain() {
		return traineedomain;
	}
	public void setTraineedomain(String traineedomain) {
		this.traineedomain = traineedomain;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeLocation=" + traineeLocation
				+ ", traineedomain=" + traineedomain + "]";
	}
	public Trainee(int traineeId, String traineeName, String traineeLocation,
			String traineedomain) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeLocation = traineeLocation;
		this.traineedomain = traineedomain;
	}
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
