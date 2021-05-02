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

	@Override
	public List<Word> getWords() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Word> query = currentSession.createQuery("from Word order by polishWord", Word.class);
		
		List<Word> words = query.getResultList();
		
		return words;
	}

	@Override
	public Word getWord(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Word word = currentSession.get(Word.class, id);
		
		return word;		
	}

	@Override
	public void deleteWord(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from Word where id=:wordId");
		
		query.setParameter("wordId", id);
		
		query.executeUpdate();
		
	}

	@Override
	public void updateWord(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Word> query = currentSession.createQuery("UPDATE Words SET polish_word= :polishWord " +
												""		);
		
	}

	@Override
	public void saveWord(Word word) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(word);

		
	}

	
	
	
}
