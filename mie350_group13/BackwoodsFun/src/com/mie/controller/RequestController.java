package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.RequestDao;
import com.mie.dao.UserDao;
import com.mie.model.Request;
import com.mie.model.User;

import net.ucanaccess.jdbc.Session;


public class RequestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDao dao;
	private RequestDao daoReq;
	
	public RequestController() {
		super();
		dao = new UserDao();
		daoReq = new RequestDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		Request req = new Request();
		
		req.setHome(user.getTeam());
		req.setAway(request.getParameter("away"));
		req.setLocation(request.getParameter("location"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("dob"));
			req.setDate(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		req.setTime(request.getParameter("time"));
		req.setReqAdmin(user.getEmail());
		req.setRepAdmin(dao.getTeamAdminEmail(dao.getAllUsers(), request.getParameter("away")));
		
		daoReq.addRequest(req);
		
		//INSERT PAGE DIRECTORY TO GO BACK AND ADD ANOTHER REQUEST
	}

}
