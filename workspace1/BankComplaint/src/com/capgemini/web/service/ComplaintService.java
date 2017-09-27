package com.capgemini.web.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.capgemini.web.dao.ComplaintDAOImpl;
import com.capgemini.web.dao.IComplaintDAO;
import com.capgemini.web.dto.ComplaintBean;
import com.capgemini.web.exception.ComplaintException;

public class ComplaintService implements IComplaintService {
	private IComplaintDAO complaintDAO;
	public ComplaintService()
	{
		complaintDAO =new ComplaintDAOImpl();
	}
	@Override
	public int raiseComplaint(ComplaintBean complaint)
			throws ComplaintException {
		int complaintId=0;
		complaintId=complaintDAO.raiseComplaint(complaint);
		return complaintId;
	}

	@Override
	public ComplaintBean getComplaintStatus(int complaintId)
			throws ComplaintException, SQLException, NamingException {
		ComplaintBean complaint =null;
		complaint =complaintDAO.getComplaintStatus(complaintId);
		return complaint;
	}

}
