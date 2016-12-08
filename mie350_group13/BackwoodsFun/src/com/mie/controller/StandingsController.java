package com.mie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.StandingsDao;
import com.mie.model.Team;
import com.mie.model.User;

public class StandingsController extends HttpServlet {
	
	private static String LIST_STANDINGS = "/viewStandings.jsp";
	
	private static final long serialVersionUID = 1L;
    private StandingsDao daoStand;   
   
    public StandingsController() {
        super();
        daoStand = new StandingsDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listStandings")) {
			forward = LIST_STANDINGS;	
			request.setAttribute("standings", daoStand.getAllStandings());
		}else {
			//forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
