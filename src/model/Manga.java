package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manga")
public class Manga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idanga")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idManga;
	
	@Column(name="name")
	private String name;
	
	@Column(name="chapters")
	private Integer chapters;
	
	@Column(name="totalChapters")
	private Integer totalChapters;
	
	@Column(name="authors")
	private String authors;
	
	

	public Manga(String name, Integer totalChapters, String authors) {
		super();
		this.name = name;
		this.totalChapters = totalChapters;
		this.authors = authors;
	}
	
	public Manga() {
		
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
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
	 * @return the authors
	 */
	public final String getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public final void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * @return the totalChapters
	 */
	public final Integer getTotalChapters() {
		return totalChapters;
	}

	/**
	 * @param totalChapters the totalChapters to set
	 */
	public final void setTotalChapters(Integer totalChapters) {
		this.totalChapters = totalChapters;
	}
	

}
