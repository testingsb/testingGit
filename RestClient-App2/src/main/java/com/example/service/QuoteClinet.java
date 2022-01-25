package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.response.QuoteApiResponse;

@Service
public class QuoteClinet {

	public String invokeRandomQuoteApi() {
		String apiUrl = "https://quoters.apps.pcfone.io/api/random";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<QuoteApiResponse> responseEntity =  restTemplate.getForEntity(apiUrl, QuoteApiResponse.class);
		
		int status = responseEntity.getStatusCodeValue();
		if(status == 200) {
			QuoteApiResponse body = responseEntity.getBody();
			return body.getValue().getQuote().toUpperCase();
		}
		return null;
	}

}
