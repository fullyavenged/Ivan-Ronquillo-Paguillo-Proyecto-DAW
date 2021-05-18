package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Anime;

public class AnimeDAO {

	private static SessionFactory sf;
	private static Session session;
	
	public static void addAnime(String name, Integer totalChapters, String status, String studios, String source, String synopsis) {
		Anime ani1 = new Anime();
		
		if (AnimeDAO.validateAnime(name)) {
			ani1.setName("Initial D");
			ani1.setTotalChapters(26);
			ani1.setStudios("Gallop");
			ani1.setSource("Manga");
			
			session.saveOrUpdate(ani1);
			
			session.getTransaction().commit();
			session.close();
		}
		
		
	}
	
	public static boolean validateAnime(String name) {
		
		session = sf.openSession();
		session.beginTransaction();
		
		Anime ani = (Anime) session.createQuery("FROM Anime A WHERE A.name = :name").setParameter("name", name)
                .uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		
		return ani != null;
	}
	
}
