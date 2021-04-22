package pl.walaszczyk.learningtool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.walaszczyk.learningtool.dao.WordDAO;
import pl.walaszczyk.learningtool.entity.Word;

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
	
	@Autowired
	private WordDAO wordDAO;
	
	@RequestMapping("/list")
	public String listDictionary(Model theModel) {
		
		List<Word> words = wordDAO.getWords();
		
		theModel.addAttribute("words", words);
		
		return "list-dictionary";
	}
	
}
