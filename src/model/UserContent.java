 package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CONTENT")
public class UserContent {

	@Id
	@Column(name="ID_USER_CONTENT")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUserContent;
	
	@ManyToOne
	@JoinColumn(name = "ID_CONTENT")
	private Content content;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@Column(name="SCORE", nullable = true)
	private Double score;
	
	@Column(name="CHAPTERS", nullable = true)
	private Integer chapters = 0;
	
	@Column(name="STATUS", nullable = true)
	@Enumerated(EnumType.STRING)
	private Status status;

	public UserContent() {
		super();
	}

	public UserContent(Content content, User user) {
		super();
		this.content = content;
		this.user = user;
	}

	/**
	 * @return the content
	 */
	public final Content getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public final void setContent(Content content) {
		this.content = content;
	}

	/**
	 * @return the user
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public final void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the score
	 */
	public final Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public final void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the chapters
	 */
	public final Integer getChapters() {
		return chapters;
	}

	/**
	 * @param chapters the chapters to set
	 */
	public final void setChapters(Integer chapters) {
		this.chapters = chapters;
	}

	/**
	 * @return the status
	 */
	public final Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
