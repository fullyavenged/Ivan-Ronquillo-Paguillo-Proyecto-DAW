package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Anime;
import model.Content;
import model.ContentType;
import model.User;
import model.UserContent;
import util.HibernateUtil;

public class ContentDAO {

	private static SessionFactory sf;
	private static Session session;

	public static void addContent(Content content) {

		if (content != null && ContentDAO.getUniqueContent(content.getName(), content.getContentType()) == null) {

			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();

			session.saveOrUpdate(content);

			session.getTransaction().commit();
			session.close();
		}

	}

	public static void deleteContent(Content content) {

		if (content != null) {

			String name = content.getName();

			ContentType contentType = content.getContentType();

			Content cont = ContentDAO.getUniqueContent(name, contentType);

			if (cont != null) {

				sf = HibernateUtil.getSessionFactory();

				session = sf.openSession();
				session.beginTransaction();

				session.delete(cont);

				session.getTransaction().commit();
				session.close();
			}

		}
	}

	public static void modifyContent(Content content) {

		if (content != null && ContentDAO.getUniqueContent(content.getName(), content.getContentType()) != null) {
			
			Content cont = ContentDAO.getUniqueContent(content.getName(), content.getContentType());
			
			if (content.getTotalChapters() != null) {
				cont.setTotalChapters(content.getTotalChapters());
			}
			
			if (!content.getAuthors().equals("")) {
				
				cont.setAuthors(content.getAuthors());
			}
			
			if (!content.getSynopsis().equals("")) {
				
				cont.setSynopsis(content.getSynopsis());
			}
			
			if (!content.getSource().equals("")) {
				
				cont.setSource(content.getSource());
			}
			
			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();
			
			session.update(cont);
			
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public static void addContentList(Content content, User user) {
		
		if (content != null && ContentDAO.getUniqueContent(content.getName(), content.getContentType()) != null) {
			
			Content cont = ContentDAO.getUniqueContent(content.getName(), content.getContentType());
			
			UserContent userc = new UserContent(cont, user);
			
			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();
			
			session.update(user);
			session.saveOrUpdate(userc);
			
			session.getTransaction().commit();
			session.close();
		}
		
	}


//	public static void deleteContent(String name, ContentType contentType) {
//
//		if (name != null && contentType != null) {
//
//			Content cont = ContentDAO.getUniqueContent(name, contentType);
//
//			if (cont != null) {
//				sf = HibernateUtil.getSessionFactory();
//
//				session = sf.openSession();
//				session.beginTransaction();
//
//				session.delete(cont);
//
//				session.getTransaction().commit();
//				session.close();
//
//			}
//		}
//	}

//	public static boolean validateAnime(String name) {
//
//		sf = HibernateUtil.getSessionFactory();
//
//		session = sf.openSession();
//		session.beginTransaction();
//
//		Anime ani = (Anime) session.createQuery("FROM Anime A WHERE A.name = :name").setParameter("name", name)
//				.uniqueResult();
//
//		session.getTransaction().commit();
//		session.close();
//
//		return ani != null;
//	}

	public static Set<Content> getContent() {

		List<Content> cont = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		cont = (List<Content>) session.createQuery("FROM Content").list();

		session.getTransaction().commit();
		session.close();

		Set<Content> result = new HashSet<Content>(cont);

		return result;

	}

	public static Set<Content> getContent(ContentType contentType) {

		List<Content> cont = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		cont = (List<Content>) session.createQuery("FROM Content C WHERE C.contentType = :CT")
				.setParameter("CT", contentType).list();

		session.getTransaction().commit();
		session.close();

		Set<Content> result = new HashSet<Content>(cont);

		return result;
	}

	public static Content getUniqueContent(String name, ContentType contentType) {

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		Content cont = null;

		cont = (Content) session.createQuery("FROM Content C WHERE C.contentType = :CT AND C.name = :cname")
				.setParameter("CT", contentType).setParameter("cname", name).uniqueResult();

		session.getTransaction().commit();
		session.close();

		return cont;

	}

	public static Set<Content> getContent(String name) {

		List<Content> cont = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		name = "%"+name+"%";
		
		cont = (List<Content>) session.createQuery("FROM Content C WHERE C.name LIKE :cname").setParameter("cname", name)
				.list();

		session.getTransaction().commit();
		session.close();

		Set<Content> result = new HashSet<Content>(cont);

		return result;

	}

}
