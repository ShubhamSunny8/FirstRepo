package com.cg.movieticket.service;

import java.util.ArrayList;

import com.cg.movieticket.bean.Ticket;
import com.cg.movieticket.exception.MovieException;

public interface MovieService {

	public ArrayList<Ticket> showMovieDetails(String city,String movie) throws MovieException;
	public boolean updateStatus(String movieId) throws MovieException;
}
