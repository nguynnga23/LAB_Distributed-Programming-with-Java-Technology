package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 20, 2024
 */
@Entity
@Table(name = "publishers")
public class Publisher implements Serializable {

	private static final long serialVersionUID = -5539653158485020112L;
	@Id
	@Column(name = "publisher_id")
	private String id;

	private String name;
	private String address;
	private String email;
	private String phone;

	@OneToMany(mappedBy = "publisher")
	private Set<Book> books;

	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publisher(String id, String name, String address, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
				+ phone  + "]";
	}

}
