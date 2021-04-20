package pl.walaszczyk.learningtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	/*
	 * Login page:
	 * - login field
	 * - password field
	 * 
	 * - sign in button (?)
	 * 	- up to sing in form
	 */

	@RequestMapping("/loginPage")
	public String loginPage(Model theModel) {
		
		return "login-page";
	}
	
}
