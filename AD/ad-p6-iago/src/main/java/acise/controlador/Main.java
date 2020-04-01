package acise.controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import acise.modelo.entidad.Usuario;

public class Main {

	public static void main(String[] args) {
		
		crearUser();
	}


	private static void crearUser() {
		Usuario user = new Usuario();
		user.setClave("clave");
		user.setDni("dni123");
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
