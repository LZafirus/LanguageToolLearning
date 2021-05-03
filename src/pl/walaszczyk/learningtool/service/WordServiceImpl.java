package pl.walaszczyk.learningtool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.walaszczyk.learningtool.dao.WordDAO;
import pl.walaszczyk.learningtool.entity.Word;

@Service
public class WordServiceImpl implements WordService {
	
	@Autowired
	private WordDAO wordDAO;
	
	@Override
	@Transactional
	public List<Word> getWords() {
		return wordDAO.getWords();
	}
	
	@Override
	@Transactional
	public void saveWord(Word word) {
		wordDAO.saveWord(word);
	}

	@Override
	@Transactional
	public Word getWord(int id) {
		return wordDAO.getWord(id);
	}

	@Override
	@Transactional
	public void deleteWord(int id) {
		wordDAO.deleteWord(id);
	}

	@Override
	@Transactional
	public List<Word> searchWords(String searchWord) {
		return wordDAO.searchWords(searchWord);
	}
}
