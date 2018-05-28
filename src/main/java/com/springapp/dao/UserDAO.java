package com.springapp.dao;

import com.springapp.exception.DAOException;
import com.springapp.exception.LoginException;
import com.springapp.model.User;

public interface UserDAO {
	
	User login(String username, String password) throws LoginException, DAOException, Exception;
	
	 
}
