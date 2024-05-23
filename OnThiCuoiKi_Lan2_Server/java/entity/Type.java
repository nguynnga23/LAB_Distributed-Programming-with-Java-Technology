package entity;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
public enum Type {
	APPETIZER("Appetizer"), MAIN_COURSE("Main Course"), OTHER("Other");
	
	private String type;;

	
	private Type(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
