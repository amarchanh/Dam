package MyPackEnterprise;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	
	// Creates the session
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		}
		catch( Throwable e) {
			System.out.println("Initial SessionFactory creation failes. " +e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	// Returns the session
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
