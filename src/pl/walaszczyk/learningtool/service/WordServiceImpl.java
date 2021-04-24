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
	public void saveWord(Word word) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Word getWord(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteWord(int id) {
		wordDAO.deleteWord(id);
	}

	@Override
	public List<Word> searchWords(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
