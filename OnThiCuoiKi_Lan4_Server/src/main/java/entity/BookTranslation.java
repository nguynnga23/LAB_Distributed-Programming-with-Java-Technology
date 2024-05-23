package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 20, 2024
 */
@Entity
@Table(name = "book_translations")
public class BookTranslation extends Book {
	private static final long serialVersionUID = -2143054569122961648L;
	@Column(name = "translate_name")
	private String translateName;
	private String language;

	public BookTranslation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookTranslation(String iSBN, String name, int publishYear, int numOfPages, double price) {
		super(iSBN, name, publishYear, numOfPages, price);
		// TODO Auto-generated constructor stub
	}

	public BookTranslation(String iSBN, String name, int publishYear, int numOfPages, double price,
			String translateName, String language) {
		super(iSBN, name, publishYear, numOfPages, price);
		this.translateName = translateName;
		this.language = language;
	}

	public String getTranslateName() {
		return translateName;
	}

	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

//	@Override
//	public String toString() {
//		return "BookTranslation [translateName=" + translateName + ", language=" + language + ", ISBN=" + ISBN
//				+ ", name=" + name + ", publishYear=" + publishYear + ", numOfPages=" + numOfPages + ", price=" + price
//				+ ", authors=" + authors + ", publisher=" + publisher + "]";
//	}

}
