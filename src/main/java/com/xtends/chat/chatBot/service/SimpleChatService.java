package com.xtends.chat.chatBot.service;

import org.springframework.stereotype.Service;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceContext;
import ai.api.AIServiceContextBuilder;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

@Service
public class SimpleChatService {

	private AIDataService aiDataService;

	public SimpleChatService() {
		AIConfiguration aiConfig = new AIConfiguration("b9a7a91630224227bd97cb4ae5fdcadb");
		aiDataService = new AIDataService(aiConfig);
	}

	public AIResponse execute(String query, String sessionId) throws AIServiceException {

		AIRequest aiRequest = new AIRequest(query);
		AIServiceContext context = null;

		if (sessionId != null) {
			context = AIServiceContextBuilder.buildFromSessionId(sessionId);
		}
		
		

		if (context != null) {
			return aiDataService.request(aiRequest, context);
		}
		
		return aiDataService.request(aiRequest);
	}
}
