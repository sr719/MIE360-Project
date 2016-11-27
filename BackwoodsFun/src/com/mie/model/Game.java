package com.mie.model;

import java.util.Date;

public class Game {

	private String home;
	private String away;
	private String location;
	private Date date;
	private String time;
	
	public Game(){
		
	}
	
	public void setHome(String home) {
		this.home = home;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getHome() {
		return this.home;
	}

	public String getAway() {
		return this.away;
	}

	public String getLocation() {
		return this.location;
	}

	public Date getDate() {
		return this.date;
	}

	public String getTime() {
		return this.time;
	}
	
	
}
