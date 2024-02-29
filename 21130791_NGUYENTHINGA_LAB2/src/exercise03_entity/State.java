package exercise03_entity;

/**
 * @author Nguyen Thi Nga
 * @date Feb 22, 2024
 */
public class State {
	private String StateName;
	private String Abbreviation;
	private String Capital;
	private int Statehood;
	private int id;

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(String stateName, String abbreviation, String capital, int statehood, int id) {
		super();
		StateName = stateName;
		Abbreviation = abbreviation;
		Capital = capital;
		Statehood = statehood;
		this.id = id;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public String getAbbreviation() {
		return Abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		Abbreviation = abbreviation;
	}

	public String getCapital() {
		return Capital;
	}

	public void setCapital(String capital) {
		Capital = capital;
	}

	public int getStatehood() {
		return Statehood;
	}

	public void setStatehood(int statehood) {
		Statehood = statehood;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "State [StateName=" + StateName + ", Abbreviation=" + Abbreviation + ", Capital=" + Capital
				+ ", Statehood=" + Statehood + ", id=" + id + "]";
	}

}
