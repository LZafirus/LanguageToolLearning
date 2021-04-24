package pl.walaszczyk.learningtool.dao;

import java.util.List;

import pl.walaszczyk.learningtool.entity.Word;

public interface WordDAO {

	public List<Word> getWords();
	
	public Word getWord();
	
	public void deleteWord(int id);
	
	public void updateWord(int id);
	
	
	
}
