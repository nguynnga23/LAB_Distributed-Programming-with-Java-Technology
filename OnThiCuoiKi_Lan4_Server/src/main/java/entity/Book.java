package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 20, 2024
 */

@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(name = "Book.listRatedBooks", query = "SELECT b FROM Book b JOIN b.authors a JOIN b.reviews r WHERE a LIKE :author AND r.rating >= :rating") })
public class Book implements Serializable {
	private static final long serialVersionUID = -2782879510856558503L;
	@Id
	protected String ISBN;
	protected String name;
	@Column(name = "publish_year")
	protected int publishYear;
	@Column(name = "num_of_pages")
	protected int numOfPages;
	protected double price;

	@ElementCollection
	@CollectionTable(name = "books_authors", joinColumns = @JoinColumn(name = "ISBN"))
	@Column(name = "author", nullable = false)
	protected Set<String> authors;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	protected Publisher publisher;

	@OneToMany(mappedBy = "book")
	protected Set<Reviews> reviews;

	public Book() {
		super();
	}

	public Book(String iSBN, String name, int publishYear, int numOfPages, double price) {
		super();
		ISBN = iSBN;
		this.name = name;
		this.publishYear = publishYear;
		this.numOfPages = numOfPages;
		this.price = price;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", name=" + name + ", publishYear=" + publishYear + ", numOfPages=" + numOfPages
				+ ", price=" + price + "]";
	}

}
