package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.RequestDao;
import com.mie.dao.ScheduleDao;
import com.mie.dao.StandingsDao;
import com.mie.dao.TeamDao;
import com.mie.model.Request;
import com.mie.model.Schedule;
import com.mie.model.Team;
import com.mie.model.User;


/**
 * Servlet implementation class StandingsController
 */
public class ScheduleController extends HttpServlet {

	private static String FULL_SCHEDULE = "/FullCalendar.jsp";
	private static String CURRENT_SCHEDULE = "/LeagueSchedule.jsp";
	private static String CURRENT_SCHEDULE_ADMIN = "/AdminSchedule.jsp";
	

	private static final long serialVersionUID = 1L;
	private static final String ADD_GAME = "/addResult.jsp";
	private static final String ADD_REQUEST_RESULT = "/addRequestResult.jsp";

	private static final String HOMEPAGE = "/homepage.jsp";
	private static final String REQUEST_RESULT = "/requestResult.jsp";
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
		if (action==null)
			action="";
		
		if (action.equalsIgnoreCase("fullSchedule")) {// RETURN HERE
			
			forward = FULL_SCHEDULE;
			request.setAttribute("length", daoSchedule.getAllSchedules().size());
			request.setAttribute("schedules", daoSchedule.getAllSchedules());
			
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
		} 
		else if(action.equalsIgnoreCase("addGame")) {
			forward=ADD_GAME;
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("user");
			TeamDao teamDao=new TeamDao();
			List<Team> otherTeams= teamDao.getOtherTeams(user.getTeam(),user);
			Team[] others= new Team[otherTeams.size()];
			others=otherTeams.toArray(others);
		/*	for (int i=0; i<otherTeams.size();i++){
				System.out.println(otherTeams.get(i).getName());
			}*/
			request.setAttribute("otherTeams", otherTeams);
			
		}
		else if(action.equalsIgnoreCase("requestResult")) {
			
			// WORK ON THIS LATER
			forward=REQUEST_RESULT;
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("user");		
			
		/*	for (int i=0; i<otherTeams.size();i++){
				System.out.println(otherTeams.get(i).getName());
			}*/
			List<Schedule> noResults =new ArrayList<Schedule>();
			noResults=daoSchedule.getOtherSchedules(user.getTeam()) ;
			request.setAttribute("noResults",noResults );
		}
		else if(action.equalsIgnoreCase("result")) {
			HttpSession session = request.getSession(false);
			int reqId = Integer.parseInt(request.getParameter("reqID"));
			RequestDao daoReq=new RequestDao();
			Schedule result=daoSchedule.getResultById(reqId);
			User user = (User) session.getAttribute("user");
			forward=ADD_REQUEST_RESULT;
			if (result.getHome()==user.getTeam()){
				result.setHomeOrAway("Home");
				request.setAttribute("opponent",result.getAway() );

			}
			else {
				result.setHomeOrAway("Away");
				request.setAttribute("opponent",result.getHome() );
				
			}
			request.setAttribute("result",result );

		}
		else {

			forward=HOMEPAGE;
			
					}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
		if (forward==ADD_GAME)
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		Schedule game=new Schedule();
		String teamLoc=request.getParameter("Loc");
		//setting home and away 
		if(teamLoc.equals("Home")){
			game.setHome(user.getTeam());
			game.setAway(request.getParameter("opponent"));
		}
		else if(teamLoc.equals("Away")){
			game.setAway(user.getTeam());
			game.setHome(request.getParameter("opponent"));

		}
		String location=request.getParameter("Location");
		for(int i=location.length();i<30;i++)
			location+=" ";
		game.setLocation(location);
		
		try {
			Date gameDate = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("game_Date"));
			// don't ask what happened below... I dunno why either
			game.setGame_Date( gameDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		game.setGame_time(request.getParameter("time"));
		String homeScore=request.getParameter("HomeScore");
		String awayScore=request.getParameter("AwayScore");
		String result=homeScore+"-"+awayScore;
		game.setResult(result);
		daoSchedule.addResult(game);
		RequestDispatcher view = request.getRequestDispatcher(HOMEPAGE);
		view.forward(request, response);

	}

}