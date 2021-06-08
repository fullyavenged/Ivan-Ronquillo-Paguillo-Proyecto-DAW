package beans;

import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import dao.UserDAO;
import model.User;

@ManagedBean(name = "login")
public class LoginBean {

	private String damn = "Log In";
	private String username = "";
	private String password = "";
	
	 @ManagedProperty(value="#{auth}")
	    private AuthBean authBean; // +setter

	public final String doLogin(String username, String password) {
		if (UserDAO.validate(username) && (password.equals("admin") && username.equals("admin"))) {

			authBean.setUser(UserDAO.getUser(username));
			return "admin?faces-redirect=true";
		} else if(UserDAO.tryLogIn(username, password)) {
			
			authBean.setUser(UserDAO.getUser(username));
			return "profile?faces-redirect=true";
		}
		else {
			return "login?redirect=true";
		}

	}

	public final String doSignIn(String username, String password) {

			if (UserDAO.addUser(username, password)) {
				return "login?faces-redirect=true";
			}
			
			return "";
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	private Set<User> users = UserDAO.getAllUsers();

	/**
	 * @return the users
	 */
	public final Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public final void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * @return the username
	 */
	public final String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public final void setUsername(String username) {
		this.username = username;
	}

//	public final String doLogin() {
//		return username;
//	}

	/**
	 * @return the damn
	 */
	public final String getDamn() {
		return damn;
	}

	/**
	 * @param damn the damn to set
	 */
	public final void setDamn(String damn) {
		this.damn = damn;
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
