package com.slk.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.slk.dto.LoginDto;
import com.slk.entity.UserEntity;
import com.slk.repository.UserRepository;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("saveuser")
	public String saveUser(UserEntity user) {

		String encPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encPassword);

		userRepo.save(user);
		return "Login";
	}

	@GetMapping(value = { "/", "login" })
	public String root() {
		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(LoginDto loginDto,Model model) {
		// verify email and password
		// email
		Optional<UserEntity> opt = userRepo.findByEmail(loginDto.getEmail());

		if (opt.isPresent()) {
			// plaintext
			// db->encrypted
			UserEntity user = opt.get();
			if (bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
				//
				return "Home";
			}
		}
		model.addAttribute("error","Invalid Credentials...");
		return "Login";

	}

}
