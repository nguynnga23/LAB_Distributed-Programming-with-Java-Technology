package entity;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class Grade {
	private Date date;
	private String grade;
	private float score;

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(Date date, String grade, float score) {
		super();
		this.date = date;
		this.grade = grade;
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade [date=" + date + ", grade=" + grade + ", score=" + score + "]";
	}

}
