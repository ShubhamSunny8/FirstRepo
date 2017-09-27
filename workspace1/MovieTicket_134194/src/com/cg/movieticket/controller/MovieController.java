package com.cg.movieticket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.movieticket.bean.Ticket;
import com.cg.movieticket.exception.MovieException;
import com.cg.movieticket.service.MovieServiceImpl;

/**
 * Servlet implementation class MovieController
 */
@WebServlet("*.obj")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieServiceImpl service = null;
		Ticket bean = null;
		String target = "";
		
		
		HttpSession session = request.getSession(true);
		// Object creations
		bean = new Ticket();
		service = new MovieServiceImpl();
		
		String path = request.getServletPath().trim();

		switch (path) {
		
		
		//  this will get the movie and city
		// will send to the movie details page if found else send to failure page
		case "/details.obj":
			String city = request.getParameter("city").trim();
			String movie = request.getParameter("movie").trim();
			ArrayList<Ticket> list = null;
			
			try {
				
				list = service.showMovieDetails(city, movie);
			
			} catch (MovieException e) {
				// TODO Auto-generated catch block
				session.setAttribute("error", e.getMessage());
				
			}
			
			if(!list.isEmpty()){
				session.setAttribute("list", list);
				session.setAttribute("movie", movie);
				session.setAttribute("city", city);
				target = "MovieDetails.jsp";
			} else{
				session.setAttribute("list", null);
				target = "failure.jsp";
			}
			
			break;
			
			
			//this will update the status and send to success page
		case "/Booked.obj":
			String movieId= request.getParameter("id").trim();
			System.out.println(movieId);
			boolean check = false;
			
			try {
				check = service.updateStatus(movieId);
				session.setAttribute("mcode", movieId);
				
				target="Success.jsp";
				
			} catch (MovieException e) {
				// TODO Auto-generated catch block
				session.setAttribute("error", e.getMessage());
			}
			break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);
		
	}

}
