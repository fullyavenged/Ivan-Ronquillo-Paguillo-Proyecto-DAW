package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;

import model.User;

@ManagedBean(name = "auth")
@SessionScoped
public class AuthBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;
	
	public final boolean isAuth() {
		
		return user != null;
	}

	/**
	 * @return the user
	 */
	public final User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public final void setUser(User user) {
		this.user = user;
	}

}
