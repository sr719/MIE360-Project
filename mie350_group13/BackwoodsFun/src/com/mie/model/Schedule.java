package com.mie.model;

import java.util.Date;

public class Schedule {
private String Home;
private String Away;
private String Location;
private Date game_Date;
private String game_time;
private String result;
private String Game;
private int id;
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
public void setGame_Date(Date gameDate) {
	this.game_Date = gameDate;
	

}
public String getGame_time() {
	
	return game_time;
	

}
public void setGame_time(String game_time) {
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
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}


