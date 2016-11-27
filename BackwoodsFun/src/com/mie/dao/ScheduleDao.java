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
	
	public void addTeam(Team team){
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Team(team_Name,number_players) values (?, ?)");
			
			// Parameters start with 1
						preparedStatement.setString(1, team.getName());
						preparedStatement.setInt(2, 1);
						preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addOnePlayer(Team team){
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Team set number_players=?"
							+ " where team_Name=?");
			// Parameters start with 1
			preparedStatement.setInt(1, team.getNumPlayers()+1);
			preparedStatement.setString(2, team.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List <User> getTeamInfo(String teamName, List<User> list){
		List <User> newList;
		newList = list;
		
		for(int i = 0;i < newList.size(); i++){
			if(!(newList.get(i).getTeam() == teamName))
			{
				newList.remove(i);
			}
		}
		
		return newList;
	}

	public List<Schedule> getAllSchedules() {
		List<Schedule> schedules = new ArrayList<Schedule>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Schedule");
			while (rs.next()) {
				Schedule schedule= new Schedule();
				schedule.setHome(rs.getString("Home"));
				schedule.setAway(rs.getString("Away"));
				schedule.setLocation(rs.getString("Location"));
				schedule.setGame_Date(rs.getDate("game_Date"));
				schedule.setGame_time(rs.getTime("game_Time"));
				schedule.setResult(rs.getString("Result"));
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
				schedule.setHome(rs.getString("Home"));
				schedule.setAway(rs.getString("Away"));
				schedule.setLocation(rs.getString("Location"));
				schedule.setGame_Date(rs.getDate("game_Date"));
				schedule.setGame_time(rs.getTime("game_Time"));
				schedule.setResult(rs.getString("Result"));
				result.add(schedule);
				
				}		
			}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
}
