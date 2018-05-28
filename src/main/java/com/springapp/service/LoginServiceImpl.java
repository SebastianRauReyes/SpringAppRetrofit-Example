package com.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springapp.dao.UserDAO;
import com.springapp.model.User;

@Service
public class LoginServiceImpl implements LoginService{
	
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User validate(String username, String password) throws Exception {
	
		User user=userDAO.login(username, password);
		return user;
		
	}

}
