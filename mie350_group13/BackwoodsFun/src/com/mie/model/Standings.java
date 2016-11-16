package com.mie.model;

public class Standings {

	private String Team;
	private int Wins;
	private int Losses;
	private int Ties;
	private int Pts;
		
	public Standings(){
		
	}
	
	public void setTeam (String team) {
		this.Team = team;
	}
	
	public void setWins(int wins) {
		this.Wins = wins;
	}
	
	public void setLosses(int losses) {
		this.Losses = losses;
	}
	
	public void setTies(int ties) {
		this.Ties = ties;
	}
	
	public void setPts(int pts) {
		this.Pts = pts;
	}
	
	public String getTeam(){
		return this.Team;
	}
	
	public int getWins(){
		return this.Wins;
	}
	
	public int getTies(){
		return this.Ties;
	}
	
	public int getLosses(){
		return this.Losses;
	}
	
	public int getPts(){
		return this.Pts;
	}
}
