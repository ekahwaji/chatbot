package com.xtends.chat.chatBot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.xtends.chat.chatBot.model.AIWebhookRequest;
import com.xtends.chat.chatBot.model.Account;
import com.xtends.chat.chatBot.model.AccountType;
import com.xtends.chat.chatBot.model.Currency;

import ai.api.GsonFactory;
import ai.api.model.Fulfillment;

@RestController
@RequestMapping("/dialogFlow")
public class DialogFlowWebHook {

	private Logger logger = LoggerFactory.getLogger(DialogFlowWebHook.class);
	private HttpClient httpClient = HttpClients.createDefault();
	private final Gson gson = GsonFactory.getDefaultFactory().getGson();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@PostMapping(value = "/webhook", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Fulfillment> doWebHook(HttpServletRequest request) throws Exception {
		/*
		HttpGet httpGet = new HttpGet("http://api.population.io:80/1.0/population/" + getValue(input, "year") + "/"
				+ getValue(input, "geo-country") + "/" + getValue(input, "age"));
		httpGet.setHeader(HttpHeaders.ACCEPT, "application/json");

		HttpResponse httpResponse = httpClient.execute(httpGet);

		HttpEntity entity = httpResponse.getEntity();*/
		AIWebhookRequest input = gson.fromJson(request.getReader(), AIWebhookRequest.class);
		String action = input.getResult().getAction();
		String result = "";
		logger.info(input.toString());
		logger.info("parameters {} ",input.getResult().getParameters());
		if("process_accounts".equals(action))
		{
			
			result =getAccounts();
			logger.info(result);
		}
		else if("category_spending".equals(action))
		{
			String category = input.getResult().getStringParameter("category");
			result = getCategorySpending(category);
		}
		
		Fulfillment output = new Fulfillment();
		output.setSpeech(result);

		return new ResponseEntity<Fulfillment>(output, HttpStatus.OK);
	}
	
	private String getCategorySpending(String categoryName)
	{
		Map<String,String> result = new HashMap<String,String>();
		
		ObjectMapper mapper = new ObjectMapper();
		String resultStr = "{}";
		try {
			 
			if("shopping".equals(categoryName.toLowerCase()))
			{
				result.put("amount", "200$");
			}
			else if("groceries".equals(categoryName.toLowerCase()))
			{
				result.put("amount", "600$");
			}
			else
			{
				result.put("amount", "0$");
				result.put("message", "no amount found from "+categoryName+" ");
			}
			
			resultStr = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			logger.error("Error in getting category spending",e);
		}
		
		return resultStr;
	}

	private String getAccounts() {
		
		List<Account> accounts = new ArrayList<Account>();
		String result = "[]";
		try{
			Currency currency = new Currency();
			currency.setCode("1");
			currency.setIsoCode("USD");
			currency.setName("United state dollar");
			currency.setSymbole("$");

			Currency counterCurrency = new Currency();
			counterCurrency.setCode("2");
			counterCurrency.setIsoCode("LBP");
			counterCurrency.setName("Lebanese Pound");
			counterCurrency.setSymbole("LBP");

			Account account = null;
			AccountType accountType = null;

			account = new Account();
			account.setAccountNumber("4567891473690584");
			account.setAvailableBalance(120000);
			account.setAvailableBalanceCounter(180000000);
			accountType = new AccountType();
			accountType.setCode("1");
			accountType.setName("currentAccount");
			accountType.setLabel("Current Account");
			account.setType(accountType);
			account.setCurrency(currency);
			account.setPrincipalAmount(2000);
			account.setPrincipalAmountCounter(3000000);
			account.setMaturityDate(getDate("10/10/2019"));
			account.setInterestRate(1.75);
			account.setCardLimit(2000);
			account.setCardLimitCounter(3000000);
			account.setCounterCurrency(counterCurrency);
			accounts.add(account);

			account = new Account();
			account.setAccountNumber("3284812548690690");
			account.setAvailableBalance(70000);
			accountType = new AccountType();
			accountType.setCode("2");
			accountType.setName("savingAccount");
			accountType.setLabel("Saving Account");
			account.setType(accountType);
			account.setCurrency(currency);
			account.setCardLimit(2000);
			account.setCardLimitCounter(3000000);
			account.setAvailableBalanceCounter(90000000);
			account.setPrincipalAmount(2000);
			account.setPrincipalAmountCounter(3000000);
			account.setMaturityDate(getDate("10/10/2017"));
			account.setInterestRate(2.5);
			account.setCounterCurrency(counterCurrency);
			accounts.add(account);

			account = new Account();
			account.setAccountNumber("1234812548693256");
			account.setAvailableBalance(6000);
			account.setAvailableBalanceCounter(9000000);
			accountType = new AccountType();
			accountType.setCode("3");
			accountType.setName("creditCard");
			accountType.setLabel("Credit Card");
			account.setType(accountType);
			account.setCurrency(currency);
			account.setPrincipalAmount(2000);
			account.setPrincipalAmountCounter(3000000);
			account.setMaturityDate(getDate("18/10/2019"));
			account.setCardLimit(1000);
			account.setCardLimitCounter(1500000);
			account.setInterestRate(1.75);
			account.setCounterCurrency(counterCurrency);
			account.setNextPayment(550);
			account.setNextPaymentCounter(825000);
			accounts.add(account);

			account = new Account();
			account.setAccountNumber("5678812579132589");
			account.setAvailableBalance(110000);
			account.setMonthlyPayment(1150);
			accountType = new AccountType();
			accountType.setCode("4");
			accountType.setName("businessLoan");
			accountType.setLabel("Business Loan");
			account.setType(accountType);
			account.setCurrency(currency);
			accounts.add(account);

			account = new Account();
			account.setAccountNumber("6413781279131593");
			account.setAvailableBalance(23500);
			accountType = new AccountType();
			accountType.setCode("5");
			accountType.setName("cheques");
			accountType.setLabel("Cheques");
			account.setType(accountType);
			account.setCurrency(currency);
			accounts.add(account);
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(accounts);
		}catch(Exception e){
			logger.error("Error in loading accounts",e);
		}
		
        return result;
	}

	public Date getDate(String dateStr) throws ParseException{
		return dateFormat.parse(dateStr);
	}
	
	private String getValue(AIWebhookRequest input, String property) {
		return input.getResult().getStringParameter(property);
	}
}
