package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.CurrentUserSession;
import com.masai.entity.Login;
import com.masai.entity.User;
import com.masai.repository.CurrentUserSessionRepo;
import com.masai.repository.UserRepo;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl implements LoginServices{
	@Autowired
	private UserRepo ur;
	@Autowired
	private CurrentUserSessionRepo currentUserRepo;

	@Override
	public CurrentUserSession login(Login log) throws LoginException {
		Optional<User> ocurrentCustomer = ur.findByUsername(log.getUsername());
		User currentCustomer = ocurrentCustomer.get();
		if (!ocurrentCustomer.isPresent())
			throw new LoginException("Incorrect Email_ID");

		Optional<CurrentUserSession> opt = currentUserRepo.findById(currentCustomer.getUserId());

		if (opt.isPresent()) {
			throw new LoginException("User Already LOgged In...");
		}

		String key = RandomString.make(6);

		CurrentUserSession cSession = new CurrentUserSession(currentCustomer.getUserId(), LocalDateTime.now(), key);
		return currentUserRepo.save(cSession);

	}

	@Override
	public String Logout(String uuid) throws LoginException {

		CurrentUserSession activeUserSession = currentUserRepo.findByUuid(uuid);

		if (activeUserSession == null)
			throw new LoginException("Incorrect uuid or userAlready logged out..");

		currentUserRepo.delete(activeUserSession);
		return "Logged Out...";
	}

}
