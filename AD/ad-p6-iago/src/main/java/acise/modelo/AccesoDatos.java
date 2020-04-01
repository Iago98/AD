package acise.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import acise.controlador.HibernateControler;
import acise.modelo.entidad.Examen;


public class AccesoDatos {
	
	
	private static Set<Examen> recuperarExamen(Integer id) {
		
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		List<Examen> result1 = session.createQuery("from Examen").list();
		session.getTransaction().commit();
		session.close();
        Set<Examen> result = new HashSet<Examen>(result1);
		return result;
		
	}
	
	
	

}
