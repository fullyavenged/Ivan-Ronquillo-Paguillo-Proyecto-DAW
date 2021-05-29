package beans;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;

import model.User;

@ManagedBean(name = "auth")
@Scope("session")
public class AuthBean {
	
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
