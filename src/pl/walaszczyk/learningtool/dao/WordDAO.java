package pl.walaszczyk.learningtool.dao;

import java.util.List;

import pl.walaszczyk.learningtool.entity.Word;

public interface WordDAO {

	public List<Word> getWords(int theSortField);
	
	public Word getWord(int id);
	
	public void deleteWord(int id);
		
	public void saveWord(Word word);

	public List<Word> searchWords(String searchWord);
	
}
