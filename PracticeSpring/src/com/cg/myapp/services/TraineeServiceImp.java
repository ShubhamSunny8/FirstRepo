package com.cg.myapp.services;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cg.myapp.daos.TraineeDao;
import com.cg.myapp.dto.Trainee;
import com.cg.myapp.exception.TraineeException;

@Service
@Transactional
public class TraineeServiceImp implements TraineeServices {
	@Resource
	private TraineeDao dao;
	@Override
	public List<Trainee> getTraineeList() throws TraineeException {
		// TODO Auto-generated method stub
		return dao.getTraineeList();
	}
	
	@Override
	public void insertNewTrainee(Trainee trainee) throws TraineeException {
		// TODO Auto-generated method stub
		dao.insertNewTrainee(trainee);
	}
	@Override
	public Trainee getTraineeOnId(int traineeId) throws TraineeException {
		// TODO Auto-generated method stub
		return dao.getTraineeOnId(traineeId);
	}
	@Override
	public void updateTrainee(Trainee tr) throws TraineeException {
		// TODO Auto-generated method stub
		dao.updateTrainee(tr);
		
	}
}
