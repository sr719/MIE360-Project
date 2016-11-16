package com.mie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.StandingsDao;

/**
 * Servlet implementation class StandingsController
 */
public class StandingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StandingsDao daoStand;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StandingsController() {
        super();
        daoStand = new StandingsDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
