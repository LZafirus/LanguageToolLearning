package pl.walaszczyk.learningtool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dictionary")
public class Word {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="polish_word")
	private String polishWord;
	
	@Column(name="foreign_word")
	private String foreignWord;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolishWord() {
		return polishWord;
	}

	public void setPolishWord(String polishWord) {
		this.polishWord = polishWord;
	}

	public String getForeignWord() {
		return foreignWord;
	}

	public void setForeignWord(String foreignWord) {
		this.foreignWord = foreignWord;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Word(int id, String polishWord, String foreignWord) {
		super();
		this.id = id;
		this.polishWord = polishWord;
		this.foreignWord = foreignWord;
	}

	public Word() {
		super();
	}
}
