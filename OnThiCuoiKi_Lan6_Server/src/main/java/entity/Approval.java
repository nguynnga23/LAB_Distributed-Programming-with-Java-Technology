package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
@Embeddable
public class Approval implements java.io.Serializable {
	private static final long serialVersionUID = -7133435309821287537L;
	@Column(name = "approved_date")
	private LocalDate approvedDate;
	private Status status;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(LocalDate approvedDate, Status status) {
		super();
		this.approvedDate = approvedDate;
		this.status = status;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Approval [approvedDate=" + approvedDate + ", status=" + status + "]";
	}

}
