package pl.walaszczyk.learningtool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.walaszczyk.learningtool.entity.Word;
import pl.walaszczyk.learningtool.service.WordService;
import pl.walaszczyk.learningtool.utility.SortUtils;

@Controller
@RequestMapping("/words")
public class WordController {

	@Autowired
	private WordService wordService;	
	
	/*
	 * All words here - as a list 
	 * 
	 * at the top - search field with button
	 * 
	 * table with headers to sort 
	 */
	

	/*
	 * Shows main page of dictionary / done
	 */
	
	@GetMapping("/list")
	public String listWords(Model theModel, @RequestParam(required=false) String sort) {
		
		List<Word> words = null;
		
		if(sort != null) {
			int theSortField = Integer.parseInt(sort);
			words = wordService.getWords(theSortField);
		}
		else {
			words = wordService.getWords(SortUtils.POLISH_WORD);
		}
		
		theModel.addAttribute("words", words);
		
		return "list-words";
	}
	
	/*
	 *  Shows form to add a word / done
	 */
	
	@GetMapping("/addWordForm")
	public String addWord(Model theModel) {
		
		Word word = new Word();
		
		theModel.addAttribute("words", word);
		return "addWord-form";
	}
	
	/*
	 *  Method to add a word / done
	 */
	
	@PostMapping("/saveWord")
	public String saveWord(@ModelAttribute("words") Word word) {
		
		wordService.saveWord(word);
		
		return "addWord-form";
	}
	
	@PostMapping("/saveEdited")
	public String saveWordEdited(@ModelAttribute("words") Word word) {
		wordService.saveWord(word);
		
		return "redirect:/words/list";
	}
	
	/*
	 *  Shows form to update a word
	 */
	@GetMapping("/updateWordForm")
	public String updateWordForm(@RequestParam("wordId") int id, Model theModel) {
		
		Word word = wordService.getWord(id);
		theModel.addAttribute("words", word);
		
		return "updateWordForm";
	}	
	
	/*
	 *  Delete method / done
	 */
	
	@GetMapping("/deleteWord")
	public String deleteWord(@RequestParam("wordId") int id, Model theModel) {
		
		wordService.deleteWord(id);

		return "redirect:/words/list";
	}	
	
	/*
	 *  Search method
	 */
	
	@GetMapping("/search")
	public String searchWord(@RequestParam("theSearchWord") String searchWord, Model theModel) {
		
		List<Word> words = wordService.searchWords(searchWord);
		
		theModel.addAttribute("words", words);
		
		return "list-words";
	}
}
