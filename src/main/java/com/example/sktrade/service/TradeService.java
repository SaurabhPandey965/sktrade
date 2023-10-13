package com.example.sktrade.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class TradeService {

	public String getTradeData() {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"https://alpha-vantage.p.rapidapi.com/query?function=FX_WEEKLY&from_symbol=EUR&to_symbol=USD&datatype=json"))
				.header("X-RapidAPI-Key", "fadf74ce55msh8f6a6642765511fp1fbc2cjsn74f4c168f60d")
				.header("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			System.out.println("response"+response.body().toString());
                     if(response.body() == null) {
                    	 throw new NullPointerException();
                     }
			return response.body().toString();
		} catch (IOException | InterruptedException e) {
			throw new HttpClientErrorException(HttpStatus.SERVICE_UNAVAILABLE,  e.getLocalizedMessage()); 
			// e.printStackTrace();
		}

	}
}
