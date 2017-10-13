package com.xtends.chat.chatBot.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xtends.chat.chatBot.model.AIWebhookRequest;

@RestController
@RequestMapping("/dialogFlow")
public class DialogFlowWebHook {

	private Logger logger = LoggerFactory.getLogger(DialogFlowWebHook.class);
	private HttpClient httpClient = HttpClients.createDefault();
	//private final Gson gson = GsonFactory.getDefaultFactory().getGson();
	
	@PostMapping(value="/webhook",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> doWebHook(@RequestBody AIWebhookRequest input) throws Exception {
		
		HttpGet httpGet = new HttpGet("http://api.population.io:80/1.0/population/" + getValue(input,"year")+ "/"
				+ getValue(input,"geo-country") + "/" + getValue(input,"age") );
		httpGet.setHeader(HttpHeaders.ACCEPT, "application/json");

		HttpResponse httpResponse = httpClient.execute(httpGet);

		HttpEntity entity = httpResponse.getEntity();

		String result = EntityUtils.toString(entity);
		
		logger.trace(result);

		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	private String getValue(AIWebhookRequest input,String property){
		return input.getResult().getStringParameter(property);
	}
}
