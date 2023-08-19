package com.slk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class EquityScrapController {

	@GetMapping("/scrap")
	public String scrap() {
		RestTemplate rt = new RestTemplate();
//		rt.getForObject("https://www.nseindia.com//api/equity-stockIndices?index=NIFTY%2050", Objec);
 
		return "Signup";
	}
}
