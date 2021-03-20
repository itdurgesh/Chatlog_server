package com.logserver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.logserver.bean.ChatLog;
import com.logserver.exception.MessageNotFoundException;
import com.logserver.mapper.Mapper;
import com.logserver.repository.ChaltLogRepository;
import com.logserver.request.ChatLogRequest;
import com.logserver.response.ChatLogResponse;
import com.logserver.service.ChatLogService;

@Service
public class ChatLogServiceImpl implements ChatLogService{
	@Autowired
	ChaltLogRepository chatlogRepository;

	@Override
	public long saveChatLogs(ChatLogRequest chatLogRequest, String user) {
		ChatLog chatLogEntity = Mapper.getEntityChatLogBeans(chatLogRequest, user);
		return chatlogRepository.save(chatLogEntity).getId();
	}

	@Override
	public List<ChatLogResponse> getChatLogs(String user, int limit, int start) {
		
		Pageable paging = PageRequest.of(start, limit);
		List<ChatLog> chatLogs = chatlogRepository.findByUserOrderByTimeStampDesc(user, paging);
		return Mapper.mapIntoChatLogResponse(chatLogs);
	}

	@Override
	public void deleteChatLogs(String user) {
		List<ChatLog> messages = chatlogRepository.findAllByUser(user);
		chatlogRepository.deleteAll(messages);
	} 

	@Override
	public void deleteChatLog(String user, long msgId) {
		ChatLog chatlog = chatlogRepository.findByUserAndId(user, msgId);
		if(!ObjectUtils.isEmpty(chatlog)){
			chatlogRepository.delete(chatlog);
		}else{
			throw new MessageNotFoundException("No message found against user:"+user+" and msgId:"+msgId);
		}
		
		
	}

}
