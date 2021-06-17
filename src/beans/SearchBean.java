package beans;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dao.ContentDAO;
import dao.UserDAO;
import model.Content;
import model.ContentType;
import model.User;

@ManagedBean(name = "search")
@SessionScoped
public class SearchBean {
	
	private String searchString = "";
	private List<User> users = UserDAO.getAllUsers();
	private boolean useless = true;
	
	@ManagedProperty(value="#{result}")
    private ResultBean resultBean; // +setter
	
	@ManagedProperty(value="#{auth}")
    private AuthBean authBean; // +setter
	
	public final String goResult(String searchString) {
		
		resultBean.setSearchString(searchString);
		
		resultBean.searchContent(searchString);
		
		return "result?faces-redirect=true";
	}
	
	public final String goSearch() {
		
		return "search?faces-redirect=true";
	}
	
	public final String searchAnime(){
		
		resultBean.setContentSet(ContentDAO.getContent(ContentType.ANIME));
		
		return "animanga?faces-redirect=true";
	}
	
public final String searchManga(){
	
		resultBean.setContentSet(ContentDAO.getContent(ContentType.MANGA));
		
		return "animanga?faces-redirect=true";
	}

	/**
	 * @return the resultBean
	 */
	public final ResultBean getResultBean() {
		return resultBean;
	}

	/**
	 * @param resultBean the resultBean to set
	 */
	public final void setResultBean(ResultBean resultBean) {
		this.resultBean = resultBean;
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
	 * @return the users
	 */
	public final List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public final void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the useless
	 */
	public final boolean isUseless() {
		return useless;
	}

	/**
	 * @param useless the useless to set
	 */
	public final void setUseless(boolean useless) {
		this.useless = useless;
	}

}
