package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.RequestDao;
import com.mie.dao.TeamDao;
import com.mie.dao.UserDao;
import com.mie.model.Request;
import com.mie.model.Team;
import com.mie.model.User;

public class TeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao dao;
	private RequestDao daoReq;
	private TeamDao daoTeam;
	
	private static String LIST_TEAM = "/viewMyTeam.jsp";
	private static String HOMEPAGE = "/homepage.jsp";
	private static String JOINTEAM = "/joinTeam.jsp";
   
    public TeamController() {
        super();
        dao = new UserDao();
		daoReq = new RequestDao();
		daoTeam = new TeamDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listTeam")) {
			forward = LIST_TEAM;
			User user = new User();
			HttpSession session = request.getSession(false);
			user = (User) session.getAttribute("user");
			request.setAttribute("users", daoTeam.getTeamInfo(user.getTeam(), dao.getAllUsers()));
			request.setAttribute("team", user.getTeam());
		} else if (action.equalsIgnoreCase("joinTeam")) {
			forward = HOMEPAGE;
			User user = new User();
			HttpSession session = request.getSession(false);
			user = (User) session.getAttribute("user");
			
			String name = request.getParameter("team");
			Team join = new Team();
			join = daoTeam.getTeam(name);
			daoTeam.addOnePlayer(join);
			request.setAttribute("teams", daoTeam.getAllTeams());
			
			user.setTeam(name);
			dao.updateUser(user);
		}else if (action.equalsIgnoreCase("listAllTeams")) {
			forward = JOINTEAM;
			User user = new User();
			
			request.setAttribute("teams", daoTeam.getAllTeams());
		}else {
			//forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Team team = new Team();
		User user = new User();
		HttpSession session = request.getSession(false);
		user = (User) session.getAttribute("user");
		String tName=request.getParameter("tname");
		for(int i=tName.length();i<100;i++)
			tName+=" ";
		team.setName(tName);
		
		daoTeam.addTeam(team);
		user.setisAdmin(true);
		user.setTeam(request.getParameter("tname"));
		dao.updateUser(user);
		//INSERT CODE TO CREATE NEW TEAM STANDING TUPLE (BLANK)
		
		RequestDispatcher view = request.getRequestDispatcher(HOMEPAGE);
		view.forward(request, response);
	}

}
