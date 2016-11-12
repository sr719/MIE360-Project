package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Request;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class RequestDao {

	private Connection connection;

	public RequestDao() {
		connection = DbUtil.getConnection();
	}
	
	public List<Request> getAllRequests() {
		List<Request> requests = new ArrayList<Request>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Requests");
			while (rs.next()) {
				Request request = new Request();
				request.setHome(rs.getString("Home"));
				request.setAway(rs.getString("Away"));
				request.setLocation(rs.getString("Location"));
				request.setDate(rs.getDate("game_Date"));
				request.setTime(rs.getString("game_Time"));
				request.setRepAdmin(rs.getString("reply_Admin"));
				request.setReqAdmin(rs.getString("request_Admin"));
				request.setKey(rs.getDate("game_Date") + "*" + rs.getString("request_Admin") );
				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return requests;
	}
	
	public void addRequest(Request req) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Requests(Home,Away,Location,game_Date,game_Time,reply_Admin,request_Admin) values (?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, req.getHome());
			preparedStatement.setString(2, req.getAway());
			preparedStatement.setString(3, req.getLocation());
			preparedStatement.setDate(4, new java.sql.Date(req.getDate().getTime()));
			preparedStatement.setString(5, req.getTime());
			preparedStatement.setString(6, req.getRepAdmin());
			preparedStatement.setString(7, req.getReqAdmin());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void declineRequest(String reqID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Requests where game_Date=? and request_Admin=?");
			// Parameters start with 1
			String[] parts = reqID.split("*");
			String date = parts[0];
			String admin = parts[1];
			
			preparedStatement.setString(1, date);
			preparedStatement.setString(2, admin);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void acceptRequest(String reqID) {
			List<Request> requests = getAllRequests();
			Request accepted = new Request();
			for(int i =0; i < requests.size(); i++)
			{
				if(requests.get(i).getKey() == reqID){
					accepted = requests.get(i);
					break;
				}
			}
			
			//PASS REQUEST OBJECT INTO SCHEDULE CLASS TO ADD IT TO THE SCHEDULE
			//FUNCTION/CLASS NOT YET  CREATED
			
			declineRequest(reqID);
	}
	
}
