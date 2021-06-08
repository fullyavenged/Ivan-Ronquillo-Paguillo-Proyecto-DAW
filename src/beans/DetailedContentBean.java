package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Content;

@ManagedBean(name = "detailedC")
@SessionScoped
public class DetailedContentBean {
	
	private Content selectedContent;

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
	
}
