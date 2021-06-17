package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Content;
import model.ContentType;
import model.Status;
import model.User;
import model.UserContent;
import util.HibernateUtil;

public class UserContentDAO {

	private static SessionFactory sf;
	private static Session session;

	public static List<UserContent> getUserAnime(User user) {

		List<UserContent> cont = null;

		ContentType contentType = ContentType.ANIME;

		int id = user.getIdUser();

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		cont = (List<UserContent>) session.createQuery(
				"FROM UserContent C WHERE C.user.idUser = :ID AND C.content.contentType = :CT ORDER BY C.status")
				.setParameter("ID", id).setParameter("CT", contentType).list();

		session.getTransaction().commit();
		session.close();

		return cont;

	}

	public static List<UserContent> getUserManga(User user) {

		List<UserContent> cont = null;

		ContentType contentType = ContentType.MANGA;

		int id = user.getIdUser();

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		cont = (List<UserContent>) session
				.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.content.contentType = :CT")
				.setParameter("ID", id).setParameter("CT", contentType).list();

		session.getTransaction().commit();
		session.close();

		return cont;

	}

	public static UserContent getUniqueUserContent(UserContent userC) {

		UserContent usr = null;
		Integer id = userC.getUser().getIdUser();
		String name = userC.getContent().getName();

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		usr = (UserContent) session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.content.name = :N")
				.setParameter("ID", id).setParameter("N", name).uniqueResult();

		session.getTransaction().commit();
		session.close();

		return usr;

	}

	public static UserContent getUniqueUserContent(User user) {

		UserContent usr = null;
		Integer id = user.getIdUser();

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		usr = (UserContent) session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.content.name = :N")
				.setParameter("ID", id);

		session.getTransaction().commit();
		session.close();

		return usr;

	}

	public static void updateChapters(UserContent userContent) {

		Integer chap = userContent.getChapters();

		if (chap + 1 == userContent.getContent().getTotalChapters()) {
			userContent.setStatus(Status.COMPLETED);

			userContent.setChapters(chap + 1);

			session = sf.openSession();
			session.beginTransaction();

			session.update(userContent);

			session.getTransaction().commit();
			session.close();
		} else if (chap != userContent.getContent().getTotalChapters()) {
			userContent.setChapters(chap + 1);

			session = sf.openSession();
			session.beginTransaction();

			session.update(userContent);

			session.getTransaction().commit();
			session.close();
		}

	}
	
	public static void resetChapters(UserContent uContent) {
		
		uContent.setChapters(0);
		
		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		session.update(uContent);

		session.getTransaction().commit();
		session.close();
		
	}

	public static void updateUserContent(UserContent uContent) {

		if (uContent != null) {

			sf = HibernateUtil.getSessionFactory();

			session = sf.openSession();
			session.beginTransaction();

			session.update(uContent);

			session.getTransaction().commit();
			session.close();
		}
	}

	public static void deleteUserContent(UserContent uContent) {

		UserContent uc = null;

		uc = getUniqueUserContent(uContent);

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		if (uc != null) {
			session.delete(uc);
		}

		session.getTransaction().commit();
		session.close();

	}

	public static void deleteUserContentRelated(Content content) {

		sf = HibernateUtil.getSessionFactory();

		int id = content.getIdContent();

		session = sf.openSession();
		session.beginTransaction();

		session.createQuery("DELETE UserContent U WHERE U.content.idContent = :ID").setParameter("ID", id)
				.executeUpdate();

		session.getTransaction().commit();
		session.close();

	}
	
	public static void deleteUserContentRelated(User user) {

		sf = HibernateUtil.getSessionFactory();

		int id = user.getIdUser();

		session = sf.openSession();
		session.beginTransaction();

		session.createQuery("DELETE UserContent U WHERE U.user.idUser = :ID").setParameter("ID", id)
				.executeUpdate();

		session.getTransaction().commit();
		session.close();

	}

	public static int getContentWatching(User user) {

		int result;

		int id = user.getIdUser();

		Status status = Status.WATCHING;
		
		ContentType ct = ContentType.ANIME;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.status = :S AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("S", status).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}

	public static int getContentCompleted(User user) {

		int result;

		int id = user.getIdUser();

		Status status = Status.COMPLETED;
		
		ContentType ct = ContentType.ANIME;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.status = :S AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("S", status).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}

	public static int getContentDropped(User user) {

		int result;

		int id = user.getIdUser();

		Status status = Status.DROPPED;
		
		ContentType ct = ContentType.ANIME;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.status = :S AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("S", status).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}
	
	public static int getTotalAnime(User user) {

		int result;

		int id = user.getIdUser();

		ContentType ct = ContentType.ANIME;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}
	
//	Manga

	public static int getContentWatchingM(User user) {

		int result;

		int id = user.getIdUser();

		Status status = Status.WATCHING;
		
		ContentType ct = ContentType.MANGA;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.status = :S AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("S", status).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}

	public static int getContentCompletedM(User user) {

		int result;

		int id = user.getIdUser();

		Status status = Status.COMPLETED;
		
		ContentType ct = ContentType.MANGA;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.status = :S AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("S", status).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}

	public static int getContentDroppedM(User user) {

		int result;

		int id = user.getIdUser();

		Status status = Status.DROPPED;
		
		ContentType ct = ContentType.MANGA;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.status = :S AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("S", status).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}
	
	public static int getTotalManga(User user) {

		int result;

		int id = user.getIdUser();

		ContentType ct = ContentType.MANGA;

		sf = HibernateUtil.getSessionFactory();

		session = sf.openSession();
		session.beginTransaction();

		result = session.createQuery("FROM UserContent C WHERE C.user.idUser = :ID AND C.content.contentType = :T")
				.setParameter("T", ct).setParameter("ID", id).list().size();

		session.getTransaction().commit();
		session.close();

		return result;

	}
	
}
