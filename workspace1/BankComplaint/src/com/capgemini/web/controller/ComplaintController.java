package com.capgemini.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.web.dto.ComplaintBean;
import com.capgemini.web.exception.ComplaintException;
import com.capgemini.web.service.ComplaintService;
import com.capgemini.web.service.IComplaintService;


interface Categories
{
	String InternetBanking="Internet Banking";
	String BasicBanking="Basic Banking";
	String Others="Others";
}
@WebServlet("/ComplaintController")
public class ComplaintController extends HttpServlet implements Categories{
	private static final long serialVersionUID = 1L;
       private IComplaintService complaintService;
   
    public ComplaintController() {
         complaintService = new ComplaintService();
    }
    
    protected void processrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action=request.getParameter("action");
    	switch(action)
    	{
    	case "addcomplaint":
    		String custName=request.getParameter("customername");
    		int accId=Integer.parseInt(request.getParameter("accountId"));
    		String cat=request.getParameter("categary");
    		String desc=request.getParameter("desc");
    		
    		ComplaintBean complaintBean=new ComplaintBean();
    		
    		complaintBean.setCustomerName(custName);
    		complaintBean.setAccountId(accId);
    		complaintBean.setCateogary(cat);
    		complaintBean.setDescription(desc);
    		complaintBean.setComplaintDate(new Date());
    		complaintBean.setStatus("OPEN");
    		//http://localhost:8088/BankComplaint/ComplaintController?action=addcomplaint
    		switch(cat)
    		{
    		case InternetBanking : complaintBean.setPriority("High");
    		break;
    		case BasicBanking :complaintBean.setPriority("Medium");
    		break;
    		case Others : complaintBean.setPriority("Low");
    		break;
    		}
    		System.out.println("hello1");
    		RequestDispatcher rd=null;
    		
    		try{
    			int complaintId=complaintService.raiseComplaint(complaintBean);
    			complaintBean.setId(complaintId);
    			request.setAttribute("compId", complaintId);
    			System.out.println("in try");
    			rd=request.getRequestDispatcher("raiseComplaint.jsp");
    			
    		}
    		catch(ComplaintException e)
    		{
    			System.out.println("in catch");
    			rd=request.getRequestDispatcher("error.jsp");
    		}
    		
				rd.forward(request, response);
			
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processrequest(request,response);
	}

}
