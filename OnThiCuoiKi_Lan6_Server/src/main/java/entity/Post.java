package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {
	private static final long serialVersionUID = 237224812646019134L;
	@Id
	@Column(name = "post_id")
	private String id;
	private String title;
	private String contents;
	private int views;
	private int likes;
	private int shares;

	@Embedded
	private Approval approval;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_name")
	private Admin admin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name")
	private User user;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String title, String contents, int views, int likes, int shares, Approval approval,
			Admin admin, User user) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.views = views;
		this.likes = likes;
		this.shares = shares;
		this.approval = approval;
		this.admin = admin;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", contents=" + contents + ", views=" + views + ", likes="
				+ likes + ", shares=" + shares + ", approval=" + approval + ", admin=" + admin + ", user=" + user + "]";
	}

}
