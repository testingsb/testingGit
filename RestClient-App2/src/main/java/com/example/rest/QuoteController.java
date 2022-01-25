package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.QuoteClinet;

@RestController
public class QuoteController {
	
	@Autowired
	private QuoteClinet quoteClient ;
	
	@GetMapping("/quote")
	public String getQuote() {
		
		String message = quoteClient.invokeRandomQuoteApi();
		return message;
	}

}
