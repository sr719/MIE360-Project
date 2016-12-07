package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import net.ucanaccess.jdbc.Session;


public class RequestController extends HttpServlet {
	//hi
	private static final long serialVersionUID = 1L;
	private static String LIST_REQUEST = "/listRequest.jsp";
	private static String HOMEPAGE = "/homepage.jsp";
	private static String NEW_REQUEST="/NewRequest.jsp";
	String forward="";
	private UserDao dao;
	private RequestDao daoReq;
	
	public RequestController() {
		super();
		dao = new UserDao();
		daoReq = new RequestDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String forward = "";
		String action = request.getParameter("action");
		//if statement below needed to get into else;
		if(action==null)
			action="";
		String reqID = request.getParameter("req");

		if (action.equalsIgnoreCase("accept")) {
			daoReq.acceptRequest(reqID);
			forward = LIST_REQUEST;
			request.setAttribute("requests", daoReq.getAllRequests());
		} else if (action.equalsIgnoreCase("decline")) {
			daoReq.declineRequest(reqID);
			forward = LIST_REQUEST;
			request.setAttribute("requests", daoReq.getAllRequests());
		} else if (action.equalsIgnoreCase("listRequest")) {
			forward = LIST_REQUEST;
			request.setAttribute("requests", dao.getAllUsers());
		} 
		
		else if (action.equalsIgnoreCase("newRequest")){
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("user");
			forward=NEW_REQUEST;
			TeamDao teamDao=new TeamDao();
			List<Team> otherTeams= teamDao.getOtherTeams(user.getTeam(),user);
			Team[] others= new Team[otherTeams.size()];
			others=otherTeams.toArray(others);
		/*	for (int i=0; i<otherTeams.size();i++){
				System.out.println(otherTeams.get(i).getName());
			}*/
			request.setAttribute("otherTeams", otherTeams);

		
		}
		else{
			forward = HOMEPAGE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		//so won't get in infinite loop
		if (forward==NEW_REQUEST)
			return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		Request req = new Request();
		String action = request.getParameter("action");
	
		
		req.setHome(user.getTeam());
				
		req.setAway(request.getParameter("away"));
		req.setLocation(request.getParameter("location"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("date"));
			req.setDate(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		req.setTime(request.getParameter("time"));
		req.setReqAdmin(user.getEmail());
		req.setRepAdmin(dao.getTeamAdminEmail(dao.getAllUsers(), request.getParameter("away")));
		
		daoReq.addRequest(req);
		forward=HOMEPAGE;
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		//INSERT PAGE DIRECTORY TO GO BACK AND ADD ANOTHER REQUEST
	}

}
