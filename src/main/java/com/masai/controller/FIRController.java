package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.FIR;
import com.masai.entity.FIRResponse;
import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.service.FIRService;
import com.masai.service.UserService;

@RestController
@RequestMapping(value = "/masaiFir/user")
public class FIRController {
	@Autowired
	private UserService us;
	@Autowired
	private FIRService fs;
	
	@PostMapping("/fir")
	public ResponseEntity<FIRResponse> fileComplaint(@RequestBody FIR fir,@RequestParam String uuid)throws UserException,FIRException{
		FIRResponse response = fs.fileComplaint(fir,uuid);
		return new ResponseEntity<FIRResponse>(response, HttpStatus.CREATED);
	}
	
}
