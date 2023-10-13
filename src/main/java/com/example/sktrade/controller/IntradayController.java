package com.example.sktrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sktrade.service.TradeService;

@RestController
@RequestMapping("/v1/trade")
public class IntradayController {

	
	@Autowired
	private TradeService tradeService;
	
	@GetMapping("/getData")
	ResponseEntity<?>getData(){
		return new ResponseEntity<>(tradeService.getTradeData(), HttpStatus.OK);
	}
}
