package pl.walaszczyk.learningtool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.walaszczyk.learningtool.entity.Word;
import pl.walaszczyk.learningtool.utility.SortUtils;

@Repository
public class WordDAOImpl implements WordDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Word> getWords(int theSortField) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String theFieldName = null;
		
		switch(theSortField) {
			case SortUtils.POLISH_WORD:
				theFieldName = "polishWord";
				break;
			case SortUtils.FOREIGN_WORD:
				theFieldName = "foreignWord";
				break;
//			case SortUtils.CATEGORY:
//				theFieldName = "category";
//				break;
			default:
				theFieldName = "polishWord";
		}
		
		String queryString = "from Word order by " + theFieldName;
		
		Query<Word> query = currentSession.createQuery(queryString, Word.class);
		
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
	public void saveWord(Word word) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(word);		
	}

	/*
	 *  Add a one more security to check DB if there is such word???
	 */
	
	@Override
	public List<Word> searchWords(String searchWord) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if(searchWord != null && searchWord.trim().length() > 0 ) {
		
		query = currentSession.createQuery("from Word where lower(polishWord) like :theWord or lower(foreignWord) like :theWord", Word.class);
		
		query.setParameter("theWord", "%" + searchWord.toLowerCase() + "%");
		
		} else {
			query = currentSession.createQuery("from Word ", Word.class);
		}
		
		List<Word> words = query.getResultList();
		
		return words;
	}	
}
