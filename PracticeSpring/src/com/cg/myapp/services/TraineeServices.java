package com.cg.myapp.services;

import java.util.List;

import com.cg.myapp.dto.Trainee;
import com.cg.myapp.exception.TraineeException;

public interface TraineeServices {
	List <Trainee> getTraineeList() throws TraineeException;
	/*Trainee getEmployeeEmpOnId(int empNo) throws EmpException;
	public void insertNewEmployee(Trainee emp) throws EmpException;
	public List<Integer> getEmpNoList() throws EmpException;
	public void updateEmployee(int empNO, String empNm) throws EmpException;*/

	void insertNewTrainee(Trainee trainee) throws TraineeException;
	public Trainee getTraineeOnId(int traineeId) throws TraineeException;
	public void updateTrainee(Trainee tr) throws TraineeException;
}
