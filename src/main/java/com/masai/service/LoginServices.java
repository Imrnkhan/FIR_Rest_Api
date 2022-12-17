package com.masai.service;
import com.masai.entity.*;
import javax.security.auth.login.LoginException;

import org.springframework.stereotype.Service;


@Service
public interface LoginServices {

	public CurrentUserSession login(Login login) throws LoginException;
	public String Logout(String uuid) throws LoginException;
}
