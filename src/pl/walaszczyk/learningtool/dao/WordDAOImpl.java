package pl.walaszczyk.learningtool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.walaszczyk.learningtool.entity.Word;

@Repository
public class WordDAOImpl implements WordDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Word> getWords() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Word> query = currentSession.createQuery("from dictionary", Word.class);
		
		List<Word> words = query.getResultList();
		
		return words;
	}

	@Override
	public Word getWord() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}