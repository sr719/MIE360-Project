//Swag

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

import com.mie.dao.UserDao;
import com.mie.model.User;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private static String SEARCH_USER = "/searchFNUser.jsp";
	private UserDao dao;

	public SearchController() {
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
			//User user = dao.getUserByEmail(userId);
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
		//User user = new User();
		//user.setFirstName(request.getParameter("firstName"));
		//user.setLastName(request.getParameter("lastName"));
		
		String keyword = request.getParameter("keyword");
		
		RequestDispatcher view = request.getRequestDispatcher(SEARCH_USER);
		request.setAttribute("keyword", keyword);
		request.setAttribute("users", dao.getUserByKeyword(keyword));
		view.forward(request, response);
	}
}