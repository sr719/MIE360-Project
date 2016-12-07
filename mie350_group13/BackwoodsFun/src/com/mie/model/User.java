package com.mie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mie.dao.TeamDao;

public class User {
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	private String gender;
	private String position;
	private String password;
	private String team=" "; // THIS SHOULD NEVER BE NULL
	private boolean isAdmin=false;
	private String adminString;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	public boolean getisAdmin() {
		return isAdmin;
	}
	public void setisAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getAdminString() {
		return adminString;
	}
	public void setAdminString() {
		if(this.isAdmin) {
			this.adminString = "Yes";
			}
		else{
			this.adminString = "No";
		}
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + ", gender=" + gender + ", position=" + position 
				+ ", password=" + password + ", team=" + team + ", Admin Status=" + isAdmin +"]";
	}

}