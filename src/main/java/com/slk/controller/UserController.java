package com.slk.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.slk.entity.UserEntity;
import com.slk.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/listusers")
	public String listUsers(Model model) {

		List<UserEntity> users = userRepo.findAll(); // List<UserEn>
		model.addAttribute("users",users);
		return "ListUsers";
	}

	@GetMapping("/deleteuser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		
		Optional<UserEntity> userOpt = userRepo.findById(userId);
		UserEntity user = userOpt.get(); 
		user.setDeletedAt(new Date());
		userRepo.save(user);//update 
		return "redirect:/listusers";
	}

}
