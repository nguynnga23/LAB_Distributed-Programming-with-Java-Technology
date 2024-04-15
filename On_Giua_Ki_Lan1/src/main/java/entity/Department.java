package entity;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class Department {
//	{dean: "Rubio",name: "Computer Science",deptID: "CS",room│: "100",building: "Ajax"}
	private String dean;
	private String name;
	private String deptId;
	private String room;
	private String building;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String dean, String name, String deptId, String room, String building) {
		super();
		this.dean = dean;
		this.name = name;
		this.deptId = deptId;
		this.room = room;
		this.building = building;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Department [dean=" + dean + ", name=" + name + ", deptId=" + deptId + ", room=" + room + ", building="
				+ building + "]";
	}

}
