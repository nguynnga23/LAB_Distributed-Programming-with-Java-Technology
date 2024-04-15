package entity;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class Course {
//	{hours: 4,name: "Programming",courseID: "CS101"})
	private int hours;
	private String name;
	private String courseId;
	private Department dept;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int hours, String name, String courseId) {
		super();
		this.hours = hours;
		this.name = name;
		this.courseId = courseId;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Course [hours=" + hours + ", name=" + name + ", courseId=" + courseId + "]";
	}

}
