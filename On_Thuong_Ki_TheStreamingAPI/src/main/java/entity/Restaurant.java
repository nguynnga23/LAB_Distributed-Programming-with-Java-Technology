package entity;

import java.util.List;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class Restaurant {
	private String restaurant_id;
	private Boolean is_closed;
	private String name;
	private Address address;
	private String borough;
	private String cuisine;
	private List<Grade> grades;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String restaurant_id, Boolean is_closed, String name, Address address, String borough,
			String cuisine, List<Grade> grades) {
		super();
		this.restaurant_id = restaurant_id;
		this.is_closed = is_closed;
		this.name = name;
		this.address = address;
		this.borough = borough;
		this.cuisine = cuisine;
		this.grades = grades;
	}

	public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public Boolean getIs_closed() {
		return is_closed;
	}

	public void setIs_closed(Boolean is_closed) {
		this.is_closed = is_closed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", is_closed=" + is_closed + ", name=" + name
				+ ", address=" + address + ", borough=" + borough + ", cuisine=" + cuisine + ", grades=" + grades + "]";
	}

}
