package com.stocktracker.stock_market_tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockTracker/")
public class StockTrackerController {
	
	@GetMapping("check")
	public String checkEndPoint() {
		return "project end point is working fine .... ✨✨✨";
	}
}
