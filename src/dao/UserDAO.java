package dao;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import model.User;

public class UserDAO {

	private static SessionFactory sf;
	private static Session session;

	public static List<User> getAllUsers() {

		List<User> users = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		users = (List<User>) session.createQuery("FROM User").list();

		session.getTransaction().commit();
		session.close();

		return users;

	}

	public static boolean addUser(String username, String password) {

		User usr = null;

		sf = HibernateUtil.getSessionFactory();

		if (!UserDAO.tryLogIn(username, password)) {
			session = sf.openSession();
			session.beginTransaction();

			usr = new User();
			usr.setUsername(username);
			usr.setPassword(password);
			session.save(usr);

			session.getTransaction().commit();
			session.close();

			return true;
		} else {
			return false;
		}
	}

	public static void deleteUser(User user) {

		if (user != null) {

			User use = getUser(user);

			if (use != null) {
				sf = HibernateUtil.getSessionFactory();

				session = sf.openSession();
				session.beginTransaction();

				session.delete(use);

				session.getTransaction().commit();
				session.close();
			}

		}

	}

	public static User getUniqueUser(String username) {

		User user = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
				.uniqueResult();

		session.getTransaction().commit();
		session.close();

		return user;
	}

	public static boolean tryLogIn(String username, String password) {

		if (username != null && password != null) {
			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();

			User user = null;

			user = (User) session.createQuery("FROM User U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();

			session.getTransaction().commit();
			session.close();

			return (user != null && user.getPassword().equals(password));
		}

		return false;

	}

	public static boolean validate(String username) {

		return getUser(username) != null;
	}

	public static User getUser(String username) {

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		User user = null;

		user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
				.uniqueResult();

		session.getTransaction().commit();
		session.close();

		return user;
	}

	public static User getUser(User user) {

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		String username = user.getUsername();

		user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
				.uniqueResult();

		session.getTransaction().commit();
		session.close();

		return user;
	}
	
	public static void updateUser(User user) {
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		session.update(user);

		session.getTransaction().commit();
		session.close();
	}
}
