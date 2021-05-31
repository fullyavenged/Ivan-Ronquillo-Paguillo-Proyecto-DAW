package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "profile")
public class UserProfileBean {

	public final String goHome() {
		
		return "login?faces-redirect=true";
	}


	public final String goList() {
		
		return "list?faces-redirect=true";
	}
}
