package com.slk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.slk.entity.UserEntity;
import com.slk.repository.UserRepository;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("saveuser")
	public String saveUser(UserEntity user) {

		userRepo.save(user);
		return "Login";
	}
}
