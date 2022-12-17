package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.*;
import com.masai.service.LoginServices;

@RestController
@RequestMapping(value="/masaicab/user")
public class SignInController {
	@Autowired
	private LoginServices lService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> loginCustomer(@RequestBody Login login) throws LoginException {
		CurrentUserSession cusr= lService.login(login);
		
		return new ResponseEntity<CurrentUserSession>(cusr,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam String UUID) throws LoginException {
	
		return new ResponseEntity<String>(lService.Logout(UUID),HttpStatus.ACCEPTED);
	}
	
}
