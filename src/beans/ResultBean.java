package beans;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;

import dao.ContentDAO;
import model.Content;
import model.ContentType;

@ManagedBean(name = "result")
@SessionScoped
public class ResultBean {
	
	String searchString;
	
	Set<Content> contentSet;
	
	@ManagedProperty(value="#{detailedC}")
    private DetailedContentBean detailedBean; // +setter
	
	public final Set<Content> searchContent(String searchString){
		contentSet = ContentDAO.getContent(searchString);
		
//ContentType xd = contentSet.iterator().next().getContentType();
		
		return contentSet;
	}
	
	public final String goDetailedC(Content content) {
		
		detailedBean.setSelectedContent(content);
		
		return "detailedc?faces-redirect=true";
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

	/**
	 * @param detailedBean the detailedBean to set
	 */
	public final void setDetailedBean(DetailedContentBean detailedBean) {
		this.detailedBean = detailedBean;
	}

}
