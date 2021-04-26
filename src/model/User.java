package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idUser")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}

	public final int getIdUser() {
		return idUser;
	}

	public final void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

}
