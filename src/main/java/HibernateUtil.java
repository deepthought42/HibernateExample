import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	 private static SessionFactory sessionFactory; 
	 static {
		 try {
             // Create the SessionFactory from hibernate.cfg.xml
             sessionFactory = new Configuration().configure().buildSessionFactory();
         } catch (Throwable ex) {
             // Make sure you log the exception, as it might be swallowed
             System.err.println("Initial SessionFactory creation failed." + ex);
             throw new ExceptionInInitializerError(ex);
         }
	 }
	 public static SessionFactory getSessionFactory() {
		 // Alternatively, you could look up in JNDI here
		 return sessionFactory;
	 }
	 public static void shutdown() {
		 // Close caches and connection pools
		 getSessionFactory().close();
	 }
}