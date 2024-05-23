package entity;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public enum Status {
	ONLINE("Online"), OFFLINE("Offline"), BUSY("Busy"), AWAY("Away");

	private String status;

	private Status(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}

}
