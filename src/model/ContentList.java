package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONTENT_LIST")
public class ContentList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_CONTENT_LIST")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idContentList;
	
	@OneToMany(mappedBy="contentList")
	private Set<Content> content;

}
