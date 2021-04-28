package pl.walaszczyk.learningtool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.walaszczyk.learningtool.dao.WordDAO;
import pl.walaszczyk.learningtool.entity.Word;
import pl.walaszczyk.learningtool.service.WordService;

@Controller
@RequestMapping("/words")
public class WordController {

	
	/*
	 * All words here - as a list 
	 * 
	 * at the top - search field with button
	 * 
	 * table with headers to sort 
	 */
	
	@Autowired
	private WordService wordService;
	
	@GetMapping("/list")
	public String listWords(Model theModel) {
		
		List<Word> words = wordService.getWords();
		
		theModel.addAttribute("words", words);
		
		return "list-words";
	}
	
	@PostMapping("/updateWordForm")
	public String updateWord(Model theModel) {
		
		return "update-word";
	}
	
	@GetMapping("/addWord")
	public String addWord(Model theModel) {
		return "addWord-form";
	}
	
	@GetMapping("/deleteWord")
	public String deleteWord(@RequestParam("wordId") int id, Model theModel) {
		
		wordService.deleteWord(id);
		
		return "redirect:/words/list";
	}
	
}
