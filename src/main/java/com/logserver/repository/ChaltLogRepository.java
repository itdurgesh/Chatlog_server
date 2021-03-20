package com.logserver.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.logserver.bean.ChatLog;
@Repository
public interface ChaltLogRepository extends CrudRepository<ChatLog,Integer> {
	
	List<ChatLog> findByUserOrderByTimeStampDesc(String user,Pageable pagable);
	
	List<ChatLog> findAllByUser(String user);
	
	ChatLog findByUserAndId(String user, long id);

}
