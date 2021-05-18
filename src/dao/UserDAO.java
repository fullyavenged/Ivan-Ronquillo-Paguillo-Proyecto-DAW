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
	
	public static Set<User> getAllUsers() {
		
		List<User> users = null;
		
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();
		
		users = (List<User>)session.createQuery("FROM User").list();
		
		session.getTransaction().commit();
		session.close();
		
		Set<User> result = new HashSet<User>(users);
		
		return result;
		
		
	}
	
	public static boolean addUser(String username, String password) {
		User usr = null;
		
		sf = HibernateUtil.getSessionFactory();
		
		
		
		if (!UserDAO.validate(username, password)) {
			session = sf.openSession();
			session.beginTransaction();
			
			usr = new User();
			usr.setUsername(username);
			usr.setPassword(password);
			session.save(usr);
			
			session.getTransaction().commit();
			session.close();
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void deleteUser(String username) {
		
		Integer num = Integer.parseInt(username);
		sf = HibernateUtil.getSessionFactory();
		

			session = sf.openSession();
			session.beginTransaction();
			
			User use = session.get(User.class, num);
			
			session.delete(use);
			
			session.getTransaction().commit();
			session.close();
		}
	
	public static boolean validate(String username, String password) {
		
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();
		
		User user = null;
		
		user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                .uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		
		return (user != null && user.getPassword().equals(password));
		
		
		
	}
	
public static boolean validate(String username) {
		
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();
		
		User user = null;
		
		user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                .uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		
		return (user != null );
		
		
		
	}
}
