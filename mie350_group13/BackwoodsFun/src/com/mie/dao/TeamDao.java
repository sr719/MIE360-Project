package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mie.model.Team;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class TeamDao {

	private Connection connection;

	public TeamDao() {
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
	
	
	
}
