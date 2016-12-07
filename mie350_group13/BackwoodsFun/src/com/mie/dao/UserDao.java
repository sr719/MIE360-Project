package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}
	
	public String getTeamAdminEmail(List<User> list, String team){
		for(int i = 0; i < list.size(); i++){
			//TEAM CLASS NEEDS TO BE IMPLEMENTED TO HAVE THIS FUNCTIONS WORK
			//THIS FUNCTION IS USED TO OBTAIN THE ADMIN EMAIL OF A TEAM ADMIN BASED ON THE
			//TEAM THAT IS PASSED INTO THE FUNCTION
			
			// WATCH OUT GET TEAM SHOULD NOT BE EMPTY
			if(list.get(i).getTeam().equalsIgnoreCase(team) && list.get(i).getisAdmin())
			{
				return list.get(i).getEmail();
			}
		}
		return "Admin not found!";
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Player(firstname,lastname,DOB,gender,position,team,isAdmin,email,password) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getPosition());
			preparedStatement.setString(6, user.getTeam());
			preparedStatement.setBoolean(7, user.getisAdmin());
			preparedStatement.setString(8, user.getEmail());
			preparedStatement.setString(9, user.getPassword());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Player set firstname=?, lastname=?, DOB=?, gender=?, position=?, team=?, isAdmin=?, email=?, password=?"
							+ " where email=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob().getTime()));
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getPosition());
			preparedStatement.setString(6, user.getTeam());
			preparedStatement.setBoolean(7, user.getisAdmin());
			preparedStatement.setString(8, user.getEmail());
			preparedStatement.setString(9, user.getPassword());
			preparedStatement.setString(10, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Player");
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("DOB"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setPosition(rs.getString("position"));
				user.setTeam(rs.getString("team"));
				user.setisAdmin(rs.getBoolean("isAdmin"));
				user.setAdminString();
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	//takes in email list and email to check and return boolean of whether or not the email exists in the DB already
	public boolean userExists(List<User> list , String email)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getEmail() == email)
			{
				return true;
			}
		}
		return false;
	}

	public boolean loginValidated(List<User> list, String uName, String pWord)
	{
		boolean email = false;
		int email_ind = -1;
		boolean password = false;
		int pass_ind = -1;
		
		for(int i = 0; i < list.size(); i++){
			if((list.get(i).getEmail()).equals(uName)){
				email = true;
				email_ind=i;
			}
			if((list.get(i).getPassword()).equals(pWord)){
				password = true;
				pass_ind=i;
			}			
		}
		
		if(!email || !password){
			return false;
		}
		if(pass_ind != -1 && email_ind != -1 && email_ind == pass_ind){
			return true;
		}else{
			return false;
		}
	}

	public User getUserByEmail(String email) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Player where email=?");
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("DOB"));
				user.setEmail(rs.getString("email"));
				user.setGender(rs.getString("gender"));
				user.setPosition(rs.getString("position"));
				user.setTeam(rs.getString("team"));
				user.setisAdmin(rs.getBoolean("isAdmin"));
				user.setAdminString();
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
/*	public User getUserByFName(String name) {
		System.out.println("test");
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where firstname=?");
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("test.................");
			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	*/
	public List<User> getUserByKeyword(String keyword) {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where firstname LIKE ? OR lastname LIKE ? OR email LIKE ? OR dob LIKE ?");
			
//			SELECT title FROM pages WHERE my_col LIKE %$param1% OR another_col LIKE %$param2%;
			
			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
}