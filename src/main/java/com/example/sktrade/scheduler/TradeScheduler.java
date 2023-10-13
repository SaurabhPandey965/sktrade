package com.example.sktrade.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.sktrade.service.TradeService;

@EnableScheduling
public class TradeScheduler {
	
@Autowired
private TradeService tradeService;
	
    @Scheduled(cron = "0/1 * * * * ?")
	public void runSchedulerJob() {
		tradeService.getTradeData();
	}
}
