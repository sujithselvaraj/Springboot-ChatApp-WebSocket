package com.sujith.chatapp.controller;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.sujith.chatapp.model.ChatMessagePOJO;

@Controller
public class ChatController {

	    @MessageMapping("/chat.sendMessage")
	    @SendTo("/topic/public")
	    public ChatMessagePOJO sendMessage(@Payload ChatMessagePOJO chatMessagePojo) {
	        return chatMessagePojo;
	    }

	    @MessageMapping("/chat.addUser")
	    @SendTo("/topic/public")
	    public ChatMessagePOJO addUser(@Payload ChatMessagePOJO chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
	        
	// Add username in web socket session
	    headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
	        return chatMessagePojo;
	    }
	}
