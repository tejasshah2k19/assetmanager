package com.slk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.slk.repository.EquityRepository;

@Controller
public class EquityController {

	@Autowired
	EquityRepository eqRepo;
	
	@GetMapping("/listequity")
	public String listEquity(Model model) {
		model.addAttribute("eqs",eqRepo.findAll());
		return "ListEquity";
	}
}
