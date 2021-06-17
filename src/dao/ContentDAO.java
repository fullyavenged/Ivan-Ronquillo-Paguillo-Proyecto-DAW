package dao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Anime;
import model.Content;
import model.ContentType;
import model.Status;
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

		if (content != null ) {
			
			
			
			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();
			
			session.update(content);
			
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public static void addContentList(Content content, User user) {
		
		if (content != null && ContentDAO.getUniqueContent(content.getName(), content.getContentType()) != null) {
			
			Content cont = ContentDAO.getUniqueContent(content.getName(), content.getContentType());
			
			UserContent userc = new UserContent(cont, user);
			
			userc.setStatus(Status.WATCHING);
			
			
			if (UserContentDAO.getUniqueUserContent(userc) == null) {
				sf = HibernateUtil.getSessionFactory();

				session = sf.openSession();
				session.beginTransaction();
				
				session.update(user);
				session.saveOrUpdate(userc);
				
				session.getTransaction().commit();
				session.close();
			}
			
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

	public static List<Content> getContent() {

		List<Content> cont = null;

		
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		cont = (List<Content>) session.createQuery("FROM Content ORDER BY name").list();

		session.getTransaction().commit();
		session.close();


		return cont;

	}

	public static List<Content> getContent(ContentType contentType) {

		List<Content> cont = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		cont = (List<Content>) session.createQuery("FROM Content C WHERE C.contentType = :CT")
				.setParameter("CT", contentType).list();

		session.getTransaction().commit();
		session.close();

		Set<Content> result = new HashSet<Content>(cont);

		return cont;
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

	public static List<Content> getContent(String name) {

		List<Content> cont = null;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		name = "%"+name+"%";
		
		cont = (List<Content>) session.createQuery("FROM Content C WHERE C.name LIKE :cname").setParameter("cname", name)
				.list();

		session.getTransaction().commit();
		session.close();


		return cont;

	}

}
