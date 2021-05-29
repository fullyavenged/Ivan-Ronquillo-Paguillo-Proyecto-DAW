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
	@JoinColumn(name = "ID_USER")
	private User user;
	
	@Column(name="SCORE")
	private Double score;
	
	@Column(name="CHAPTERS")
	private Integer chapters;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
}
