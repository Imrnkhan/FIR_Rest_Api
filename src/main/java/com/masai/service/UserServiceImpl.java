package com.masai.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.User;
import com.masai.exception.UserException;
import com.masai.repository.FIRrepo;
import com.masai.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo ur;
	@Autowired
	private FIRrepo fr;
	@Override
	public User createUser(@Valid User user)throws UserException {
		Optional<User> ou = ur.findByUsername(user.getUsername());
		if(ou.isPresent()) throw new UserException("Username already Exists");
		
		return ur.save(user);
	}

}
