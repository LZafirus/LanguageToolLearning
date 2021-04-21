package pl.walaszczyk.learningtool.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.walaszczyk.learningtool.entity.Word;

@Repository
public class WordDAOImpl implements WordDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Word> getWords() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
