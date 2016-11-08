package com.mie.model;

import java.sql.Date;

public class Request extends Game {

	private String replyAdmin;
	private String requestAdmin;
		
	public Request(){
		super();
	}
	
	public void setRepAdmin(String repAdmin) {
		this.replyAdmin = repAdmin;
	}
	
	public void setReqAdmin(String reqAdmin) {
		this.requestAdmin = reqAdmin;
	}
	
	public String getRepAdmin(){
		return this.replyAdmin;
	}
	
	public String getReqAdmin(){
		return this.requestAdmin;
	}
}
