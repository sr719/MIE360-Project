package com.mie.model;

import java.sql.Date;
import java.sql.Time;

public class Schedule {
private String Home;
private String Away;
private String Location;
private Date game_Date;
private Time game_time;
private String result;
private String Game;
public String getHome() {
	return Home;
}
public void setHome(String home) {
	Home = home;
}
public String getAway() {
	return Away;
}
public void setAway(String away) {
	Away = away;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public Date getGame_Date() {
	
	return game_Date;
}
public void setGame_Date(Date game_Date) {
	this.game_Date = game_Date;
	

}
public Time getGame_time() {
	
	return game_time;
	

}
public void setGame_time(Time game_time) {
	this.game_time = game_time;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public String getGame(){
	return Game;
}
public void setGame(){
	Game= Home +" @ " + Away;
}
public String getGameDateTime(){
	String date=game_Date.toString();
	String time=game_time.toString();
	return(date+"T"+time);
	}
}


