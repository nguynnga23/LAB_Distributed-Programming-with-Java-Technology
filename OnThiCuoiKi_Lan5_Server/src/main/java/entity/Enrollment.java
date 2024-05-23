package entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 21, 2024
 */
@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = -3648215529025296409L;
	private String semester;
	private int year;
	private int score;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enrollment(String semester, int year, int score, Student student, Course course) {
		super();
		this.semester = semester;
		this.year = year;
		this.score = score;
		this.student = student;
		this.course = course;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Enrollment [semester=" + semester + ", year=" + year + ", score=" + score + ", student=" + student
				+ ", course=" + course + "]";
	}

}
