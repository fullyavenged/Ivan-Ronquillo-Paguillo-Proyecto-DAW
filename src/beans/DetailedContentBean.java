package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dao.ContentDAO;
import model.Content;
import model.ContentType;

@ManagedBean(name = "detailedC")
@SessionScoped
public class DetailedContentBean {
	
	private Content selectedContent;
	
	@ManagedProperty(value="#{auth}")
    private AuthBean authBean; // +setter
	
	public final void addContentToList() {
		
		ContentDAO.addContentList(selectedContent, authBean.user);
	}
	
	
public final String getChapters() {
		
		return ContentType.ANIME.equals(selectedContent.getContentType())?"Episodes":"Chapters";
	}

	public final String getStudio() {
		
		return ContentType.ANIME.equals(selectedContent.getContentType())?"Studio":"Author";
	}
	public final String getSource() {
		
		return ContentType.ANIME.equals(selectedContent.getContentType())?"Source":"Serialization";
	}

	/**
	 * @return the selectedContent
	 */
	public final Content getSelectedContent() {
		return selectedContent;
	}

	/**
	 * @param selectedContent the selectedContent to set
	 */
	public final void setSelectedContent(Content selectedContent) {
		this.selectedContent = selectedContent;
	}

	/**
	 * @param authBean the authBean to set
	 */
	public final void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}
	
}
