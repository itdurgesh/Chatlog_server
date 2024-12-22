package com.logserver.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logserver.exception.MessageNotFoundException;
import com.logserver.request.ChatLogRequest;
import com.logserver.response.ChatLogResponse;
import com.logserver.service.ChatLogService;

@RestController
@RequestMapping("log-server")
public class LogServerController {
	@Autowired
	ChatLogService chatLogService;
	
	@PostMapping(path = "/chatlogs/{user}", produces = "application/json")
	public long saveChatlogs(@RequestBody ChatLogRequest chatLog, @PathVariable String user){
		return chatLogService.saveChatLogs(chatLog, user);
	}
	
	@GetMapping(path = "/chatlogs/{user}", produces = "application/json")
    public List<ChatLogResponse> getChatlogs(@PathVariable String user, 
    		@RequestParam(name = "limit", defaultValue = "10") int limit,
    		@RequestParam(name = "start", defaultValue = "0") int start){
		
		return chatLogService.getChatLogs(user, limit, start);
    }
	
	@DeleteMapping(path = "/chatlogs/{user}", produces = "application/json")
	public void deleteUsingUser(@PathVariable String user){
		chatLogService.deleteChatLogs(user);
	}
	
	@DeleteMapping(path = "/chatlogs/{user}/{messageId}", produces = "application/json")
    public void deleteUsingUserAndMessageId(@PathVariable String user,@PathVariable long messageId){
		chatLogService.deleteChatLog(user, messageId);
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ChatLogRequest cr =  new ChatLogRequest();
		cr.setMessage("xyz");
		cr.setSent(true);
		cr.setTimeStamp(new Date());
		
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(cr));
	}

}
