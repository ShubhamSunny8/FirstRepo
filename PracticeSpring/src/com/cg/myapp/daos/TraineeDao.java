package com.cg.myapp.daos;

import java.util.List;

import com.cg.myapp.dto.Trainee;
import com.cg.myapp.exception.TraineeException;



public interface TraineeDao {
	List <Trainee> getTraineeList() throws TraineeException;
	void insertNewTrainee(Trainee trainee) throws TraineeException;
	public Trainee getTraineeOnId(int traineeId) throws TraineeException;
	public void updateTrainee(Trainee tr) throws TraineeException;
}
