package entity;

import java.util.Arrays;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class Address {
	private String building;
	private Double[] coord;
	private String street;
	private String zipcode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String building, Double[] coord, String street, String zipcode) {
		super();
		this.building = building;
		this.coord = coord;
		this.street = street;
		this.zipcode = zipcode;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Double[] getCoord() {
		return coord;
	}

	public void setCoord(Double[] coord) {
		this.coord = coord;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [building=" + building + ", coord=" + Arrays.toString(coord) + ", street=" + street
				+ ", zipcode=" + zipcode + "]";
	}

}
