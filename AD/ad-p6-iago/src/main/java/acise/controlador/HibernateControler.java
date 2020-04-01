package acise.controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateControler {
	private static SessionFactory factory;

	private static void getSessionFactory() {
		try {
			if (factory == null) {
				Configuration conf = new Configuration();
				// Cargamos la configuración de hibernate.cfg.xml
				conf.configure();
				// Construimos el sessionFactory
				factory = conf.buildSessionFactory();
			}
		} catch (HibernateException exception) {
			System.out.println("Problem creating session factory");
			exception.printStackTrace();
		}
	}

	public static Session openHibernateSession() {
		getSessionFactory();
		Session sesion = factory.openSession();
		return sesion;
	}
}
