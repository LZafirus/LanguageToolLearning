package pl.walaszczyk.learningtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	
	@RequestMapping("/list")
	public String listDictionary(Model theModel) {
		
		return "list-dictionary";
	}
	
}
