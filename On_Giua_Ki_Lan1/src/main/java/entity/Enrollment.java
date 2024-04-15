package entity;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class Enrollment {
	private Course course;
	private Student student;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(Course course, Student student) {
		super();
		this.course = course;
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Enrollment [course=" + course + ", student=" + student + "]";
	}

}
