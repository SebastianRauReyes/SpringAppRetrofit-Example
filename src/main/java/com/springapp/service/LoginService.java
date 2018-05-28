package com.springapp.service;

import com.springapp.exception.DAOException;
import com.springapp.exception.LoginException;
import com.springapp.model.User;

public interface LoginService {
	
	User validate(String username, String password) throws LoginException, DAOException, Exception;
}
