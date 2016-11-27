package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mie.model.Standings;
import com.mie.util.DbUtil;

public class StandingsDao {

	private Connection connection;

	public StandingsDao() {
		connection = DbUtil.getConnection();
	}
	
	
	public void addStanding(Standings standing) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Standings(Team,Wins,Losses,Ties,Pts) values (?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, standing.getTeam());
			preparedStatement.setInt(2, 0);
			preparedStatement.setInt(3, 0);
			preparedStatement.setInt(4, 0);
			preparedStatement.setInt(5, 0);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStanding(Standings standing) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Standings(Team,Wins,Losses,Ties) values (?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, standing.getTeam());
			preparedStatement.setInt(2, standing.getWins());
			preparedStatement.setInt(3, standing.getLosses());
			preparedStatement.setInt(4, standing.getTies());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
