package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Standings;
import com.mie.model.Team;
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
	
	public Standings getStanding(Team team){
		Standings standing= new Standings();
		try {
			
			//CHECK THAT THE FIELD NAME 'TEAM' IS CORRECT
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Standings where Team=?");
			
			preparedStatement.setString(1, team.getName());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			rs.next();
			standing.setTeam(rs.getString("Team"));
			standing.setWins(rs.getInt("Wins"));
			standing.setLosses(rs.getInt("Losses"));
			standing.setTies(rs.getInt("Ties"));
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return standing;
	}
	
	public List<Standings> getAllStandings() {
		List<Standings> result = new ArrayList<Standings>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Standings");
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Standings standing= new Standings();
				standing.setTeam(rs.getString("Team"));
				standing.setWins(rs.getInt("Wins"));
				standing.setLosses(rs.getInt("Losses"));
				standing.setTies(rs.getInt("Ties"));
				standing.setPts(rs.getInt("Pts"));
				result.add(standing);
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
