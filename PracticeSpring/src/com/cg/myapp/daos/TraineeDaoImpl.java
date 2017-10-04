package com.cg.myapp.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.myapp.dto.Trainee;
import com.cg.myapp.exception.TraineeException;

@Repository
public class TraineeDaoImpl implements TraineeDao {
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Trainee> getTraineeList() throws TraineeException {
		// TODO Auto-generated method stub
		String strQry="select t from trainee t";
		TypedQuery<Trainee> qry=manager.createQuery(strQry,Trainee.class);
		List<Trainee> traineeList =qry.getResultList();
		System.out.println(traineeList);
		return traineeList;
	}

	@Override
	public void insertNewTrainee(Trainee trainee) throws TraineeException {
		// TODO Auto-generated method stub
		
		manager.persist(trainee);
	}

	@Override
	public Trainee getTraineeOnId(int traineeId) throws TraineeException {
		// TODO Auto-generated method stub
		Trainee trainee=manager.find(Trainee.class, traineeId);
		return trainee;
	}

	@Override
	public void updateTrainee(Trainee tr) throws TraineeException {
		// TODO Auto-generated method stub
		
		manager.merge(tr);
		/*trainee.setTraineeName(tr.getTraineeName());
		trainee.setTraineeLocation(tr.getTraineeLocation());
		trainee.setTraineedomain(tr.getTraineedomain()));*/
	}

	/*@Override
	public Trainee getEmployeeEmpOnId(int empNo) throws EmpException {
		// TODO Auto-generated method stub
		Trainee emp=manager.find(Trainee.class, empNo);
		return emp;
	}

	@Override
	public void insertNewEmployee(Trainee emp) throws EmpException {
		// TODO Auto-generated method stub
		manager.persist(emp);
		
	}
	public List<Integer> getEmpNoList() throws EmpException {
		// TODO Auto-generated method stub
		String strQry="select e.empNo from Employee e";
		TypedQuery<Integer> qry=manager.createQuery(strQry,Integer.class);
		List<Integer> empNoList =qry.getResultList();
		//System.out.println(empList);
		return empNoList;
	}
	
	
	@Override
	public void updateEmployee(int empNO, String empNm) throws EmpException {
		// TODO Auto-generated method stub
		Trainee emp=manager.find(Trainee.class, empNO);
		emp.setEmpNm(empNm);
	}*/

}
