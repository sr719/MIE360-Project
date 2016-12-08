package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Schedule;
import com.mie.model.Team;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class ScheduleDao {

	private Connection connection;

	public ScheduleDao() {
		connection = DbUtil.getConnection();
	}
	
	
	public List<Schedule> getAllSchedules() {
		List<Schedule> schedules = new ArrayList<Schedule>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Schedule");
			while (rs.next()) {
				Schedule schedule= new Schedule();
				schedule.setId(rs.getInt("ScheduleID"));
				schedule.setHome(rs.getString("Home"));
				schedule.setAway(rs.getString("Away"));
				schedule.setLocation(rs.getString("Location"));
				schedule.setGame_Date(rs.getDate("game_Date"));
				schedule.setGame_time(rs.getString("game_Time"));
				schedule.setResult(rs.getString("Result"));
				schedule.setGame();
				schedules.add(schedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return schedules;
	}

	public List<Schedule> getMySchedule(String teamName) {
		// TODO Auto-generated method stub
		List<Schedule> result = new ArrayList<Schedule>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Schedule where Home=?"+ "OR Away=?");
			
			preparedStatement.setString(1, teamName);
			preparedStatement.setString(2, teamName);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Schedule schedule= new Schedule();
				schedule.setId(rs.getInt("ScheduleID"));
				schedule.setHome(rs.getString("Home"));
				schedule.setAway(rs.getString("Away"));
				schedule.setLocation(rs.getString("Location"));
				schedule.setGame_Date(rs.getDate("game_Date"));
				schedule.setGame_time(rs.getString("game_Time"));
				schedule.setResult(rs.getString("Result"));
				schedule.setGame();
				result.add(schedule);
				
				}		
			}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void addResult(Schedule game) {
		// TODO Auto-generated method stub
		if(game.getId()>0)
			return;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Schedule(Home,Away,Location,game_Date,game_Time,result,ScheduleID) values (?, ?, ?, ?, ?, ?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, game.getHome());
			preparedStatement.setString(2, game.getAway());
			preparedStatement.setString(3, game.getLocation());
			preparedStatement.setDate(4, new java.sql.Date(game.getGame_Date().getTime()));
			preparedStatement.setString(5, game.getGame_time());
			preparedStatement.setString(6, game.getResult());
			preparedStatement.setInt(7,game.getId());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public   <Schedule>List getOtherSchedules(String team) {
		// TODO Auto-generated method stub
				List<com.mie.model.Schedule> result = new ArrayList<com.mie.model.Schedule>();
				List<com.mie.model.Schedule> allSchedules=getAllSchedules();
				for(int i=0;i<allSchedules.size();i++)
					if(allSchedules.get(i).getResult()==null){
						result.add(allSchedules.get(i));
					}

				return result;
	}


	public Schedule getResultById(int reqId) {
		Schedule game=new Schedule();
		ScheduleDao daoSch=new ScheduleDao();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Schedule where ScheduleID=?");
			preparedStatement.setInt(1, reqId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				game.setHome(rs.getString("Home"));
				game.setAway(rs.getString("Away"));
				game.setLocation(rs.getString("Location"));
				game.setGame_Date(rs.getDate("game_Date"));
				game.setGame_time(rs.getString("game_Time"));
				daoSch.addResult(game);

			}
			}catch (SQLException e) {
		e.printStackTrace();
	}

		return game;

	}


	public void editResult(Schedule game) {
		// TODO Auto-generated method stub
		String test="";
		test+=game.getId();
		//System.out.println(game.getId());
		System.out.println(test);
		if( test==null){
			addResult(game);
			return;
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update Schedule set Result=? where ScheduleID=?");
			// Parameters start with 1
			preparedStatement.setString(1, game.getResult());
			preparedStatement.setInt(2, game.getId());
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
