package com.mie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.ScheduleDao;
import com.mie.dao.StandingsDao;
import com.mie.model.Schedule;
import com.mie.model.User;


/**
 * Servlet implementation class StandingsController
 */
public class ScheduleController extends HttpServlet {

	private static String FULL_SCHEDULE = "fullcalendar-3.0.1/demos/default.html";
	private static String CURRENT_SCHEDULE = "/LeagueSchedule.jsp";
	private static String CURRENT_SCHEDULE_ADMIN = "/AdminSchedule.jsp";

	private static final long serialVersionUID = 1L;
    private ScheduleDao daoSchedule;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleController() {
        super();
        
        daoSchedule = new ScheduleDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("fullSchedule")) {// RETURN HERE
			
			forward = FULL_SCHEDULE;
			request.setAttribute("games", daoSchedule.getAllSchedules());
		} else if (action.equalsIgnoreCase("listSchedule"))
		{
			
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("user");
			if(user.getisAdmin())
				forward=CURRENT_SCHEDULE_ADMIN;
			else
				forward = CURRENT_SCHEDULE;

					
			//System.out.println( user.getFirstName() +user.getLastName());
			List<Schedule> mySchedule = new ArrayList<Schedule>();
			mySchedule = daoSchedule.getMySchedule(user.getTeam());
			//System.out.println(mySchedule.get(0).getLocation());
			request.setAttribute("mySchedule", mySchedule);
			
			
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = CURRENT_SCHEDULE;
			//request.setAttribute("users", dao.getAllUsers());
		} else {
			forward = CURRENT_SCHEDULE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
