package com.springapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.springapp.model.User;
import com.springapp.retrofit.ApiService;
import com.springapp.retrofit.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Response;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
		
	@Override
	public User login(String username, String password) throws Exception {

	     Response<User> response=null;
	     User user = null;
		 ApiService service = ApiServiceGenerator.createService(ApiService.class);
		 	 
	     		Call<User> call = service.login(username, password);
	    
	     		 //------------
	     		 //Call 
			     try {
						response=call.execute();
				 } catch (Exception e) {
					logger.info("Error en el servicio...");
					logger.info("onError: " + response.errorBody().string());
			   						 		
				 }
			     
			     //------------
			     //Response 
	        
		        if (response.isSuccessful()) { 	
		            user = response.body();
		            logger.info("Login success!!!");		            
		        } else {
		        	logger.info("onError: " + response.errorBody().string());
		        	        	        
		        }	    
		        
	   return user;			
	}

}
