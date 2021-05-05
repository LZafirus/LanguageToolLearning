package pl.walaszczyk.learningtool.service;

import java.util.List;

import pl.walaszczyk.learningtool.entity.Word;

public interface WordService {
	
	public void saveWord(Word word);
	
	public Word getWord(int id);
	
	public void deleteWord(int id);
	
	public List<Word> searchWords(String searchWord);
	
	public List<Word> getWords(int theSortField);
}
