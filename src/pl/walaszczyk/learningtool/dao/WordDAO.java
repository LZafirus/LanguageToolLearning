package pl.walaszczyk.learningtool.dao;

import java.util.List;

import pl.walaszczyk.learningtool.entity.Word;

public interface WordDAO {

	public List<Word> getWords();
	
	public Word getWord();
	
	
	
}
