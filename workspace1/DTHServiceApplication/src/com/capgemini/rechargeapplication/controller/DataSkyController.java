package com.capgemini.rechargeapplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.rechargeapplication.bean.SubscriberBean;
import com.capgemini.rechargeapplication.exception.RechargeException;
import com.capgemini.rechargeapplication.service.ISubscriberService;
import com.capgemini.rechargeapplication.service.SubscriberService;


@WebServlet("*.do")
public class DataSkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISubscriberService service;
    
    
    @Override
	public void init() throws ServletException {
    	service = new SubscriberService();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		switch(servletPath){
			case "/login.do":
				String mobileNumberString = request.getParameter("mobileNumber");
				long mobileNumber = Long.parseLong(mobileNumberString);
				String target = null;
				if(SubscriberService.validatePhoneNumber(mobileNumberString)){
					try {
						SubscriberBean subscriberBean = service.getAccountDetails(mobileNumber);
						if(subscriberBean != null){
							float packageAmount = service.getPackageAmount(subscriberBean.getPackageId());
							HttpSession session = request.getSession(true);
							session.setAttribute("subscriberBean", subscriberBean);
							session.setAttribute("packageAmount", packageAmount);
							target = "subAcctDetails.jsp";
						}
						else{
							target = "error.jsp";
						}
					} catch (RechargeException e) {
						target = "error.jsp";
					}
				}
				else{
					target = "error.jsp";
				}
				request.getRequestDispatcher(target).forward(request, response);
				break;
			case "/recharge.do":
				String amountString = request.getParameter("amount");
				float amount = Float.parseFloat(amountString);
				target = null;
				if(SubscriberService.validateAmount(amountString)){
					HttpSession session = request.getSession(false);
					if(session != null){
						SubscriberBean subscriberBean = (SubscriberBean) session.getAttribute("subscriberBean");
						
						try {
							boolean isUpdated = service.updateAccountDetails(subscriberBean.getSubscriberId(), 
																				subscriberBean.getAccountBalance() + amount);
							if(isUpdated){
								target = "success.jsp";
							}
							else{
								target = "error.jsp";
							}
						} catch (RechargeException e) {
							target = "error.jsp";
						}
					}
					else{
						target = "error.jsp";
					}
				}
				request.getRequestDispatcher(target).forward(request, response);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
