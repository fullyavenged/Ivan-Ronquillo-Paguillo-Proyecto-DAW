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
import util.HibernateUtil;

public class ContentDAO {

	private static SessionFactory sf;
	private static Session session;

	public static void addContent(Content content) {

		if (content != null) {

			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();

			session.saveOrUpdate(content);

			session.getTransaction().commit();
			session.close();
		}

	}

	public static boolean validateAnime(String name) {

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		Anime ani = (Anime) session.createQuery("FROM Anime A WHERE A.name = :name").setParameter("name", name)
				.uniqueResult();

		session.getTransaction().commit();
		session.close();

		return ani != null;
	}

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

		cont = (List<Content>) session.createQuery("FROM content C WHERE C.CONTENT_TYPE = :CT").setParameter("CT", contentType).list();

		session.getTransaction().commit();
		session.close();

		Set<Content> result = new HashSet<Content>(cont);

		return result;
	}

}
