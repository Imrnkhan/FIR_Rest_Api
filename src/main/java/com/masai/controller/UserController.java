package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.FIR;
import com.masai.entity.FIRResponse;
import com.masai.entity.User;
import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.service.FIRService;
import com.masai.service.UserService;

@RestController
@RequestMapping(value = "/masaifir/user")
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private FIRService fs;
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException{
		User user2 = us.createUser(user);
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);
	}
	@GetMapping("/fir")
	public ResponseEntity<List<FIR>> getAllFir(@RequestParam String username,@RequestParam String uuid) throws FIRException, UserException{
		List<FIR> l = fs.getAllFirOfUser(username,uuid);
		return new ResponseEntity<List<FIR>>(l,HttpStatus.OK);
	}
	@DeleteMapping("/fir/{firId}")
	public ResponseEntity<FIRResponse> deleteFIR(@PathVariable Integer firId,@RequestParam String username,@RequestParam String uuid) throws FIRException,UserException{
		FIRResponse response = fs.deleteFIR(firId,username,uuid);
		return new ResponseEntity<FIRResponse>(response,HttpStatus.OK);
	}
}
