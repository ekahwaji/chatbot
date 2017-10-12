package com.xtends.chat.chatBot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xtends.chat.chatBot.service.SimpleChatService;

import ai.api.AIServiceException;
import ai.api.model.AIResponse;

@RestController
@RequestMapping("/chat")
public class SimpleChatController {
    
	@Autowired
	private SimpleChatService chatService;
	
	@GetMapping(value="/ask")
	public ResponseEntity<String> respond(@RequestParam("query") String query,HttpSession session) throws AIServiceException{
		AIResponse response = chatService.execute(query, session.getId());
		return new ResponseEntity<String>(response.getResult().getFulfillment().getSpeech(), HttpStatus.OK);
	}
}
