package entity;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
public enum Size {
	SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

	private String size;

	private Size(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return size;
	}

}
