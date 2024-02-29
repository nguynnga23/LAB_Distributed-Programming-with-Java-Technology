package exercise02_entity;

public class PhoneNumbers {
	private String type;
	private String number;

	public PhoneNumbers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhoneNumbers(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumbers [type=" + type + ", number=" + number + "]";
	}

}
