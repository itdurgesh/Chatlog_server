package com.logserver.response;

import java.util.Date;


/**
 * 
 * @author durgesh.s
 *
 */
		
public class ChatLogResponse {
    private long messageId;
	
	private String user;
	
	private String message;
	
	private Date dateTime;
	
	private boolean isSent;
	

	public ChatLogResponse(long messageId, String user, String message, Date dateTime, boolean isSent) {
		super();
		this.messageId = messageId;
		this.user = user;
		this.message = message;
		this.dateTime = dateTime;
		this.isSent = isSent;
	}

	

	public long getMessageId() {
		return messageId;
	}



	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}



	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isSent() {
		return isSent;
	}

	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

	
}
