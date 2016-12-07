package com.mie.model;

public class Request extends Game {

	private String replyAdmin;
	private String requestAdmin;
	private String key;
	private int id;
		
	public Request(){
		super();
	}
	
	public void setRepAdmin(String repAdmin) {
		this.replyAdmin = repAdmin;
	}
	
	public void setReqAdmin(String reqAdmin) {
		this.requestAdmin = reqAdmin;
	}
	
	public void setKey(String key){
		this.key=key;
	}
	
	public String getRepAdmin(){
		return this.replyAdmin;
	}
	
	public String getReqAdmin(){
		return this.requestAdmin;
	}
	
	public String getKey(){
		return this.key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
