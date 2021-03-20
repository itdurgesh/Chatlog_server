/**
 * 
 */
package com.log.server.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.logserver.LogServerApplication;
import com.logserver.request.ChatLogRequest;

/**
 * @author durgesh.s
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatLogServerControllerIntegrationTest {
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }
    
    @Test
    public void testSaveChatLog() {
        ChatLogRequest chatlogReq = new ChatLogRequest();
        chatlogReq.setMessage("The Accountent");
        chatlogReq.setTimeStamp(new Date());
        chatlogReq.setSent(true);
        
        ResponseEntity<Long> postResponse = restTemplate.postForEntity(getRootUrl() + "/log-server/chatlogs/123/", chatlogReq, Long.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
    }
    
    @Test
    public void testGetLogs() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<List> response = restTemplate.exchange(getRootUrl() + "/log-server/chatlogs/123/",
       HttpMethod.GET, entity, List.class);  
       assertNotNull(response.getBody());
   }
    
    @Test
	public void testRemoveMovie() {
	  	Integer user = 123;
	  	Map<String,Integer> variables = new HashMap<>();
		variables.put("user", user);
		
		try {
			restTemplate.delete(getRootUrl() + "log-server/chatlogs/{user}/",variables);
			List<List>  response = restTemplate.getForObject(getRootUrl() + "/log-server/chatlogs/123/", List.class,variables );
		    assertNotNull(response);

		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
