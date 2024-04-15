package entity;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class Student {
//	{studentID: "11",name: "Bush",gpa: 3.0}
	private String studentId;
	private String name;
	private float gpa;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String name, float gpa) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + "]";
	}

}
