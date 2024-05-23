package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 20, 2024
 */

@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {

	private static final long serialVersionUID = 4679389320083323737L;
	private int rating;
	private String comment;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ISBN")
	private Book book;
	
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;

	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reviews(int rating, String comment, Book book, Person person) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.book = book;
		this.person = person;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Reviews [rating=" + rating + ", comment=" + comment + ", book=" + book + ", person=" + person + "]";
	}

}
