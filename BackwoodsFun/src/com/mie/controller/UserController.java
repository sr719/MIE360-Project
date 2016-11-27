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

import com.mie.dao.UserDao;
import com.mie.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private static String SEARCH_FNAME_USER = "/searchFNUser.jsp";
	private static String HOMEPAGE = "/homepage.jsp";
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			dao.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			//int userId = Integer.parseInt(request.getParameter("userId"));
			//User user = dao.getUserById(userId);
			//request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("dob"));
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		user.setPosition(request.getParameter("pos"));
		user.setPassword(request.getParameter("pass"));
		//Checks if user exists based on email entered
		if (!dao.userExists(dao.getAllUsers(), user.getEmail()))
		{
			dao.addUser(user);
		} else {
			//user.setUserid(Integer.parseInt(userid));
			dao.updateUser(user);
		}
		HttpSession session = request.getSession(true);	    
        session.setAttribute("user",user);
		RequestDispatcher view = request.getRequestDispatcher(HOMEPAGE);
		view.forward(request, response);
	}
}