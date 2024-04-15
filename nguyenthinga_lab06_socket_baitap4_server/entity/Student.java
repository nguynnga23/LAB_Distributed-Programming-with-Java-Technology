package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Student")

@NamedQueries({ //JPQL
	@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByEnrollmentInYear", query = "SELECT s FROM Student s WHERE year(s.enrollmentDate) = :year"),
    @NamedQuery(name = "Student.findStudentsEnrolledInCourse", 
    						query = "select s from Student s inner join s.studentGrades sg where sg.course.title like :title")
})

//@NamedNativeQueries({
//	@NamedNativeQuery(name = "Student.findAll2", query = "select * from [dbo].[Person] where [Discriminator]='Student'")
//})
public class Student extends Person implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5054814556079295778L;

	private LocalDate enrollmentDate;
	
	@OneToMany(mappedBy = "student")
	private Set<StudentGrade> studentGrades;
    

    public Student(String firstName, String lastName, LocalDate enrollmentDate) {
        super(firstName, lastName);
        this.enrollmentDate = enrollmentDate;
    }

    public Student() {
    }
    

    
    
	public Set<StudentGrade> getStudentGrades() {
		return studentGrades;
	}

	public void setStudentGrades(Set<StudentGrade> studentGrades) {
		this.studentGrades = studentGrades;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	@Override
	public String toString() {
		return String.format("Student [enrollmentDate=%s, getId()=%s, getFirstName()=%s, getLastName()=%s]",
				enrollmentDate, getId(), getFirstName(), getLastName());
	}
    
    
}