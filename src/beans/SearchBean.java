package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "search")
public class SearchBean {
	
	private String searchString = "";
	
	@ManagedProperty(value="#{result}")
    private ResultBean resultBean; // +setter
	
	public final String goResult(String searchString) {
		
		resultBean.setSearchString(searchString);
		
		resultBean.searchContent(searchString);
		
		return "result?redirect=true";
	}
	
	public final String goSearch() {
		
		return "search?redirect=true";
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

}
