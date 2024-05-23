package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name = "comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = -6776691711352075572L;
	private String contents;
	@Id
	@Column(name = "comment_date")
	private LocalDateTime commentDate;
	private int likes;

	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name")
	private User user;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String contents, LocalDateTime commentDate, int likes, User user, Post post) {
		super();
		this.contents = contents;
		this.commentDate = commentDate;
		this.likes = likes;
		this.user = user;
		this.post = post;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [contents=" + contents + ", commentDate=" + commentDate + ", likes=" + likes + ", user=" + user
				+ ", post=" + post + "]";
	}

}
