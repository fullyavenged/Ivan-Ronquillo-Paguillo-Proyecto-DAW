package beans;

import javax.faces.bean.ManagedBean;

import dao.UserDAO;

@ManagedBean(name = "admin")
public class AdminBean {
	
	public final void userAdd(String username, String password) {
		if (!UserDAO.validate(username, password)) {
			UserDAO.addUser(username, password);
		}
		
	}
	
	public final void userDelete(String username) {

			UserDAO.deleteUser(username);

		
	}

}
