package beans;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dao.ContentDAO;
import model.Content;
import model.ContentType;

@ManagedBean(name = "search")
public class SearchBean {
	
	private String searchString = "";
	
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

}
