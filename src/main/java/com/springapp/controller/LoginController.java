package com.springapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springapp.model.User;
import com.springapp.service.LoginService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;


	//----------------------------------------------------------------------------------------------------------------
	//----- LOGIN 
	//----------------------------------------------------------------------------------------------------------------
	
	@GetMapping(value={"/", "login"})
	public ModelAndView preLogin(Model model) {
		logger.info("Welcome to Spring - Retrofit");
		User user = new User();
		return new ModelAndView("login", "command", user);
	}
	
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		logger.info("Iniciando...");
		
		ModelAndView modelAndView = null;	
		User usr = null;
		
		try {
			logger.info("Enviando username.."+user.getUsername());
			logger.info("Enviando password.."+user.getPassword());
			
			usr = loginService.validate(user.getUsername(), user.getPassword());
				
			if(usr!=null) {
				modelAndView = new ModelAndView("redirect:/admin/menu", "command", usr);
			}else {
				modelAndView = new ModelAndView("login", "command", new User());
			}
			
		} catch (Exception e) {
			
			model.addAttribute("login", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("login", "command", new User());
					
		}
			
		return modelAndView;
	}
	
	//----------------------------------------------------------------------------------------------------------------
	//----- MENU
	//----------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/admin/menu")
	public String menu() {
		return "/admin/menu";
	}
	
	
	
	
}

