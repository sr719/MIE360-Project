package com.mie.model;

import java.util.List;

public class Team {
	private String name;
	private List <String> emails;
	private List <String> firstName;
	private List <String> lastName;
	private int numPlayers;
	
	public Team(){
		
	}
	
	public void setNumPlayers(int num){
		this.numPlayers=num;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void addEmail(String email) {
		this.emails.add(email);
	}
	
	public void addFirstName(String first) {
		this.firstName.add(first);
	}
	
	public void addLastName(String last) {
		this.lastName.add(last);
	}
	
	public String getName(){
		return this.name;
	}
	
	public List <String> getfirstNames(){
		return this.firstName;
	}
	
	public List <String> getlastNames(){
		return this.lastName;
	}
	
	public List <String> getEmails(){
		return this.emails;
	}
	
	public int getNumPlayers(){
		return this.numPlayers;
	}
	
}
