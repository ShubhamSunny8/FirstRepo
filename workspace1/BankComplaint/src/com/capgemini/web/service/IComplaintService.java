package com.capgemini.web.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.capgemini.web.dto.ComplaintBean;
import com.capgemini.web.exception.ComplaintException;

public interface IComplaintService {
	
	public int raiseComplaint(ComplaintBean complaint) throws  ComplaintException;
	
	public ComplaintBean getComplaintStatus(int complaintId) throws  ComplaintException, SQLException, NamingException;
}
