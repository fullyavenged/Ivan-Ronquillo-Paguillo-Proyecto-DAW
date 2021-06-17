package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import dao.UserContentDAO;
import dao.UserDAO;
import model.UserContent;

@RequestScoped
@ManagedBean(name = "profile")
public class UserProfileBean {

	@ManagedProperty(value = "#{list}")
	private ListBean listBean; // +setter

	@ManagedProperty(value = "#{auth}")
	private AuthBean authBean; // +setter

	public final String goHome() {

		return "search?faces-redirect=true";
	}
	
	/*User*/
	
	public final void updateUser() {
		
		UserDAO.updateUser(authBean.user);
	}

	public final String goAnimeList() {

		listBean.setListContent(UserContentDAO.getUserAnime(authBean.user));

		return "list?faces-redirect=true";
	}

	public final String goMangaList() {

		listBean.setListContent(UserContentDAO.getUserManga(authBean.user));

		return "list?faces-redirect=true";
	}

	public final String goProfile() {

		return "profile?faces-redirect=true";
	}

	public final int getWatching() {

		return UserContentDAO.getContentWatching(authBean.user);
	}

	public final int getCompleted() {

		return UserContentDAO.getContentCompleted(authBean.user);
	}

	public final int getDropped() {

		return UserContentDAO.getContentDropped(authBean.user);
	}
	
	public final int getTotalAnime() {
		
		return UserContentDAO.getTotalAnime(authBean.user);
	}
	
	public final int getTotalChaptersA() {
		
		int totalChap = 0;
		
		for (int i = 0; i < UserContentDAO.getUserAnime(authBean.user).size(); i++) {
			
			totalChap = totalChap + UserContentDAO.getUserAnime(authBean.user).get(i).getChapters();
		}
		
		return totalChap;
	}
	
	/*Manga*/
	
	public final int getWatchingM() {

		return UserContentDAO.getContentWatchingM(authBean.user);
	}

	public final int getCompletedM() {

		return UserContentDAO.getContentCompletedM(authBean.user);
	}

	public final int getDroppedM() {

		return UserContentDAO.getContentDroppedM(authBean.user);
	}
	
	public final int getTotalManga() {
		
		return UserContentDAO.getTotalManga(authBean.user);
	}
	
public final int getTotalChaptersM() {
		
		int totalChap = 0;
		
		for (int i = 0; i < UserContentDAO.getUserManga(authBean.user).size(); i++) {
			
			totalChap = totalChap + UserContentDAO.getUserManga(authBean.user).get(i).getChapters();
		}
		
		return totalChap;
	}

	/**
	 * @param listBean the listBean to set
	 */
	public final void setListBean(ListBean listBean) {
		this.listBean = listBean;
	}

	/**
	 * @param authBean the authBean to set
	 */
	public final void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

}
