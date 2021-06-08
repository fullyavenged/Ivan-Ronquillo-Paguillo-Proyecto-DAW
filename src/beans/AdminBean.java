package beans;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dao.ContentDAO;
import dao.UserDAO;
import model.Content;
import model.ContentType;

@ManagedBean(name = "admin")
public class AdminBean {

	private Content newContent;
	
	@ManagedProperty(value="#{auth}")
    private AuthBean authBean; // +setter

	public final void userAdd(String username, String password) {
		if (!UserDAO.validate(username)) {
			UserDAO.addUser(username, password);
		}

	}

	public final void userDelete(String username) {

		UserDAO.deleteUser(username);

	}
	
	public final void contentAdd() {
		ContentDAO.addContent(newContent);
		
		init();
	}
	
	public final void contentDelete() {
		ContentDAO.deleteContent(newContent);
		
		init();
	}
	
	public final void contentModify() {
		ContentDAO.modifyContent(newContent);
		
		init();
	}
	
	public final void contentAddList() {
		ContentDAO.addContentList(newContent, authBean.user);
		
		init();
	}
	
	public final String goAdmin() {
		
		return "admin?faces-redirect=true";
	}
	
	public final Set<Content> getContent() {
		return ContentDAO.getContent();
	}

	@PostConstruct
	public final void init() {
		newContent = new Content();
	}

	public ContentType[] getContentTypes() {

		return ContentType.values();
	}

	/**
	 * @return the newContent
	 */
	public final Content getNewContent() {
		return newContent;
	}

	/**
	 * @param newContent the newContent to set
	 */
	public final void setNewContent(Content newContent) {
		this.newContent = newContent;
	}

	public final String getChapters() {
		
		return ContentType.ANIME.equals(newContent.getContentType())?"Episode":"Chapter";
	}

	public final String getStudio() {
		
		return ContentType.ANIME.equals(newContent.getContentType())?"Studio":"Author";
	}
	public final String getSource() {
		
		return ContentType.ANIME.equals(newContent.getContentType())?"Source":"Serialization";
	}

	/**
	 * @return the authBean
	 */
	public final AuthBean getAuthBean() {
		return authBean;
	}

	/**
	 * @param authBean the authBean to set
	 */
	public final void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

}
