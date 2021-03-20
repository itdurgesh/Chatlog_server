package com.logserver.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.logserver.bean.ChatLog;
import com.logserver.request.ChatLogRequest;
import com.logserver.response.ChatLogResponse;

/**
 * 
 * @author durgesh.s
 *
 */
public interface Mapper {
	
	public static ChatLog getEntityChatLogBeans(ChatLogRequest chatLogRequest, String user){
		
		ChatLog chatlog = new ChatLog(user,chatLogRequest.getMessage(),chatLogRequest.getTimeStamp(),chatLogRequest.isSent());
		
		return chatlog;
	}
	
	public static List<ChatLogResponse> mapIntoChatLogResponse(List<ChatLog> chatLogs){
		List<ChatLogResponse> response = new ArrayList<>();
		if(!CollectionUtils.isEmpty(chatLogs)){
			response = chatLogs.stream()
					.map(chatLog -> new ChatLogResponse(chatLog.getId(), chatLog.getUser(), chatLog.getMessage(), chatLog.getTimeStamp(), chatLog.isSent()))
					.collect(Collectors.toList());
			
		}
		return response;
		
	}
}
