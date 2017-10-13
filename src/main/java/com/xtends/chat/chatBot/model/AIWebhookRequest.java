package com.xtends.chat.chatBot.model;

import ai.api.model.AIResponse;

public class AIWebhookRequest extends AIResponse {
	private final long serialVersionUID = 1L;

	private OriginalRequest originalRequest;

	/**
	 * Get original request object
	 * 
	 * @return <code>null</code> if original request undefined in request object
	 */
	public OriginalRequest getOriginalRequest() {
		return originalRequest;
	}
}