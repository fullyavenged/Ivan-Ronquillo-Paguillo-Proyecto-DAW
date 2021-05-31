package beans;

import java.util.Set;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

import dao.ContentDAO;
import model.Content;

@ManagedBean(name = "result")
@Scope("session")
public class ResultBean {
	
	String searchString;
	
	Set<Content> contentSet;
	
	public final Set<Content> searchContent(String searchString){
		contentSet = ContentDAO.getContent(searchString);
		
		return contentSet;
	}

	/**
	 * @return the searchString
	 */
	public final String getSearchString() {
		return searchString;
	}

	/**
	 * @param searchString the searchString to set
	 */
	public final void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * @return the contentSet
	 */
	public final Set<Content> getContentSet() {
		return contentSet;
	}

	/**
	 * @param contentSet the contentSet to set
	 */
	public final void setContentSet(Set<Content> contentSet) {
		this.contentSet = contentSet;
	}

}
