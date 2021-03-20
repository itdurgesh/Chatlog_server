package com.logserver.service;

import java.util.List;

import com.logserver.request.ChatLogRequest;
import com.logserver.response.ChatLogResponse;

/**
 * 
 * @author durgesh.s
 *
 */	
public interface ChatLogService {
	public long saveChatLogs(ChatLogRequest request, String user);
	public List<ChatLogResponse> getChatLogs(String userId, int limit, int start);
	public void deleteChatLogs(String userID);
	public void deleteChatLog(String userId, long msgId);

}
