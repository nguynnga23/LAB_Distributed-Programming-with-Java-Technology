package entity;

import lombok.ToString;

/**
 * @author Nguyen Thi Nga
 * @date May 21, 2024
 */
public enum Gender {
	MALE("Male"), FEMALE("Female"), OTHER("Other");

	private String name;

	private Gender(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
