package beans;

import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import dao.UserContentDAO;
import model.Content;
import model.Status;
import model.UserContent;

@ManagedBean(name = "list")
@SessionScoped
public class ListBean {

	private List<UserContent> listContent;
	
	private UserContent editContent = new UserContent();
	
	private int[] scores = {0,1,2,3,4,5,6,7,8,9,10};

	@ManagedProperty(value = "#{detailedC}")
	private DetailedContentBean detailedBean; // +setter
	
	@ManagedProperty(value="#{auth}")
    private AuthBean authBean; // +setter

	public final String goDetailedC(Content content) {

		detailedBean.setSelectedContent(content);

		return "detailedc?faces-redirect=true";
	}
	
	public final void chaptersUpdate(UserContent uContent) {
		
		UserContentDAO.updateChapters(uContent);
		
	}
	
	public final void resetChapters() {
		
		UserContentDAO.resetChapters(editContent);
		
	}
	
	
	public final String userContentDelete() {
		
		UserContentDAO.deleteUserContent(editContent);
		
		refreshList();
		
		
		return "list";
	}
	
	public final String userContentModify() {
		
		UserContentDAO.updateUserContent(editContent);
		
		refreshList();
		
		return "list";
	}
	
	public final void setEditContentModal(UserContent content) {
		
		this.editContent = content;
		
		PrimeFaces.current().executeScript("$('#editUC').modal('show');");
		
	}
	
	public Status[] getStatus() {
		
		return Status.values();
	}

	/**
	 * @return the listContent
	 */
	public final List<UserContent> getListContent() {
		return listContent;
	}

	/**
	 * @param listContent the listContent to set
	 */
	public final void setListContent(List<UserContent> listContent) {
		this.listContent = listContent;
	}

	/**
	 * @param detailedBean the detailedBean to set
	 */
	public final void setDetailedBean(DetailedContentBean detailedBean) {
		this.detailedBean = detailedBean;
	}
	
	public final void refreshList() {
		listContent = UserContentDAO.getUserAnime(authBean.user);
	}

	/**
	 * @param authBean the authBean to set
	 */
	public final void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	/**
	 * @return the editContent
	 */
	public final UserContent getEditContent() {
		return editContent;
	}

	/**
	 * @param editContent the editContent to set
	 */
	public final void setEditContent(UserContent editContent) {
		this.editContent = editContent;
	}

	/**
	 * @return the scores
	 */
	public final int[] getScores() {
		return scores;
	}

	/**
	 * @param scores the scores to set
	 */
	public final void setScores(int[] scores) {
		this.scores = scores;
	}

}
