package com.masai.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.exception.UserException;

@Service
public interface UserService {

	public User createUser(@Valid User user)throws UserException ;

}
