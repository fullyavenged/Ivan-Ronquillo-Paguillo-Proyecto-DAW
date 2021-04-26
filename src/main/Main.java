package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.UserDAO;
import model.User;
import util.HibernateUtil;

public class Main {

	private static SessionFactory sf;
	private static Session session;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

//		User user1 = new User();
//		user1.setPassword("1234");
//		user1.setUsername("Zed");
//		
//		session.saveOrUpdate(user1);
//		
//		User user2 = new User();
//		user2.setPassword("1234");
//		user2.setUsername("Yas");
//		
//		session.saveOrUpdate(user2);
		
		if(UserDAO.validate("Zed", "1234")) {
			System.out.println("Ole");
		}
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}
