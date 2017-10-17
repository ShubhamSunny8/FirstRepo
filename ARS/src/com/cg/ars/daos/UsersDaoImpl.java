package com.cg.ars.daos;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.ars.daos.UsersDao;
import com.cg.ars.dtos.UsersBean;
import com.cg.ars.exceptions.AirlineException;

@Repository
public class UsersDaoImpl implements UsersDao{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public boolean addNewCustomer(UsersBean userBean) throws AirlineException {
		
		try {
			manager.persist(userBean);
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}
	
	@Override
	public ArrayList<String> getUserNameList() throws AirlineException {
		
		String strQry = "SELECT u.userName FROM UsersBean u";
		TypedQuery<String> qry = manager.createQuery(strQry, String.class);
		ArrayList<String> userNameList = (ArrayList<String>) qry.getResultList();
		
		return userNameList;
	}

	@Override
	public ArrayList<UsersBean> getUsersList() throws AirlineException {
		
		String strQry = "SELECT u FROM UsersBean u";
		TypedQuery<UsersBean> qry = manager.createQuery(strQry, UsersBean.class);
		ArrayList<UsersBean> userList = (ArrayList<UsersBean>) qry.getResultList();
		
		return userList;
	}

	

}
