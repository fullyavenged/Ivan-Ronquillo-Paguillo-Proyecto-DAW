package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anime")
public class Anime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idAnime")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAnime;
	
	@Column(name="name")
	private String name;
	
	@Column(name="synopsis")
	private String synopsis;
	
	@Column(name="chapters")
	private Integer chapters;
	
	@Column(name="totalChapters")
	private Integer totalChapters;
	
	@Column(name="status")
	private String status;
	
	@Column(name="studios")
	private String studios;
	
	@Column(name="source")
	private String source;

	
	public Anime(String name, Integer totalChapters, String status, String studios, String source, String synopsis) {
		super();
		this.name = name;
		this.totalChapters = totalChapters;
		this.status = status;
		this.studios = studios;
		this.source = source;
		this.synopsis =  synopsis;
	}
	
	public Anime() {
		
	}

	/**
	 * @return the idAnime
	 */
	public final int getIdAnime() {
		return idAnime;
	}

	/**
	 * @param idAnime the idAnime to set
	 */
	public final void setIdAnime(int idAnime) {
		this.idAnime = idAnime;
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
	 * @return the status
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the studios
	 */
	public final String getStudios() {
		return studios;
	}

	/**
	 * @param studios the studios to set
	 */
	public final void setStudios(String studios) {
		this.studios = studios;
	}

	/**
	 * @return the source
	 */
	public final String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public final void setSource(String source) {
		this.source = source;
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

	/**
	 * @return the synopsis
	 */
	public final String getSynopsis() {
		return synopsis;
	}

	/**
	 * @param synopsis the synopsis to set
	 */
	public final void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
}
