package com.slk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.slk.service.EquityScrapService;

@Controller
public class EquityScrapController {

	@Autowired
	EquityScrapService eqScrapService; 
	
	@GetMapping("/scrap")
	public String scrap() {
		eqScrapService.scrapPriceForDb(); 
		return "redirect:/listequity";
	}
}
