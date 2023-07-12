package com.slk.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.slk.dto.LoginDto;
import com.slk.dto.ResetPasswordDto;
import com.slk.entity.UserEntity;
import com.slk.repository.UserRepository;
import com.slk.service.MailerService;
import com.slk.service.OtpGenerator;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	OtpGenerator otpGeneratorService;

	@Autowired
	MailerService mailerService;

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
	public String authenticate(LoginDto loginDto, Model model) {
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
		model.addAttribute("error", "Invalid Credentials...");
		return "Login";

	}

	@GetMapping("forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}

	@PostMapping("forgetpassword")
	public String forgetpassword(LoginDto loginDto, Model model) {

		Optional<UserEntity> userOptional = userRepo.findByEmail(loginDto.getEmail());
		if (userOptional.isPresent()) {
			String otp = otpGeneratorService.generateOtp(6);

			UserEntity user = userOptional.get();
			user.setOtp(otp);
			mailerService.sendMailForForgetpasswordOTP(user);
			userRepo.save(user);

			return "ResetPassword";
		} else {
			model.addAttribute("error", "Email Not found , Please Enter Correct Email");
			return "ForgetPassword";
		}
	}

	@PostMapping("resetpassword")
	public String resetPassword(ResetPasswordDto rDto, Model model) {
		Optional<UserEntity> userOptional = userRepo.findByEmail(rDto.getEmail());
		if (userOptional.isPresent()) {
			UserEntity user = userOptional.get();
			if (user.getOtp().equals(rDto.getOtp())) {
				user.setPassword(bCryptPasswordEncoder.encode(rDto.getPassword()));
				userRepo.save(user);
				return "Login";
			}
		}
		model.addAttribute("error", "Invalid Credentials...");
		return "ResetPassword";
	}
}
