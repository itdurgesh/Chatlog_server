/**
 * 
 */
package com.logserver.bean;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

/**
 * @author durgesh.s
 *
 */
@Entity
public class ChatLog {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String user;
	
	@Column
	private String message;
	
	@Column
	@CreatedDate
	private Date timeStamp;
	
	@Column
	private boolean isSent;
	public ChatLog(){}
	
	public ChatLog(String user, String message, Date timeStamp, boolean isSent) {
		super();
		this.user = user;
		this.message = message;
		this.timeStamp = timeStamp;
		this.isSent = isSent;
	}

	public ChatLog(String user, String message, boolean isSent) {
		super();
		this.user = user;
		this.message = message;
		this.isSent = isSent;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
