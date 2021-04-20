package pl.walaszczyk.learningtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	
	/*
	 * All words here - as a list 
	 * 
	 * at the top - search field with button
	 * 
	 * table with headers to sort 
	 */
	
	@RequestMapping("/list")
	public String listDictionary(Model theModel) {
		
		return "list-dictionary";
	}
	
}
