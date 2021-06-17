package beans;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import dao.ContentDAO;
import dao.UserContentDAO;
import dao.UserDAO;
import model.Content;
import model.ContentType;
import model.User;
import model.UserContent;

@ManagedBean(name = "admin")
@SessionScoped
public class AdminBean {

	private Content newContent;
	private Content modifyContent;

	
	@ManagedProperty(value="#{auth}")
    private AuthBean authBean; // +setter
	
	@ManagedProperty(value="#{result}")
    private ResultBean resultBean; // +setter
	
	@ManagedProperty(value="#{login}")
    private LoginBean loginBean; // +setter

	public final void userAdd(String username, String password) {
		if (!UserDAO.validate(username)) {
			UserDAO.addUser(username, password);
			
			loginBean.setUsers(UserDAO.getAllUsers());
		}

	}

	public final void userDelete(User user) {

		UserContentDAO.deleteUserContentRelated(user);
		
		UserDAO.deleteUser(user);
		

		loginBean.setUsers(UserDAO.getAllUsers());
	}
	
	public final String contentAdd() {
		ContentDAO.addContent(newContent);
		
		init();
		
		return "admin";
	}
	
	public final void contentDelete(Content content) {
		
		UserContent ucont = new UserContent();
		
		ucont.setContent(content);
		
		UserContentDAO.deleteUserContentRelated(content);
		
		ContentDAO.deleteContent(content);
		
		
		init();
	}
	
	public final void contentModify() {
		ContentDAO.modifyContent(modifyContent);
		
		init();
	}
	
	public final void contentAddList() {
		ContentDAO.addContentList(newContent, authBean.user);
		
		init();
	}
	
	public final String goAdmin() {
		
		return "admin?faces-redirect=true";
	}
	
	public final List<Content> getContent() {
		return ContentDAO.getContent();
	}

	@PostConstruct
	public final void init() {
		newContent = new Content();
		resultBean.setContentSet(ContentDAO.getContent());
		modifyContent = new Content();
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

	/**
	 * @return the modifyContent
	 */
	public final Content getModifyContent() {
		return modifyContent;
	}

	/**
	 * @param modifyContent the modifyContent to set
	 */
	public final void setModifyContent(Content modifyContent) {
		this.modifyContent = modifyContent;
		
	}

	/**
	 * @param resultBean the resultBean to set
	 */
	public final void setResultBean(ResultBean resultBean) {
		this.resultBean = resultBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public final void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public final void setContentToModify(Content modifyContent) {
		this.modifyContent = modifyContent;
		PrimeFaces.current().executeScript("$('#modifyC').modal('show');");
	}
}
