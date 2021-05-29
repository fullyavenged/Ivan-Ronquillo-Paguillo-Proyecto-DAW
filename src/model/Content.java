package model;

import java.io.Serializable;

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
@Table(name = "CONTENT")
public class Content implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CONTENT")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idContent;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TOTAL_CHAPTERS")
	private Integer totalChapters;
	
	@Column(name="AUTHORS")
	private String authors;
	
	@Column(name="SYNOPSIS")
	private String synopsis;
	
	@Column(name="SOURCE")
	private String source;
	
	@Column(name="CONTENT_TYPE")
	@Enumerated(EnumType.STRING)
	private ContentType contentType;
	
	/*Test*/
	
//	@ManyToOne
//    @JoinColumn(name="ID_CONTENT_LIST", nullable=false)
//	private ContentList contentList;

	public Content() {
		super();
	}
	
	/**
	 * @return the idContent
	 */
	public final int getIdContent() {
		return idContent;
	}

	/**
	 * @param idContent the idContent to set
	 */
	public final void setIdContent(int idContent) {
		this.idContent = idContent;
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
	 * @return the contentType
	 */
	public final ContentType getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public final void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	
	
}
