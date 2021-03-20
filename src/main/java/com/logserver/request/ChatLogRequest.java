
package com.logserver.request;

import java.util.Date;

/**
 * @author durgesh.s
 * The Bean class is use as request to  create chatLog in chat log server
 */
public class ChatLogRequest {
	private String message;
	private Date timeStamp;
	private boolean isSent;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public boolean isSent() {
		return isSent;
	}
	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

}
