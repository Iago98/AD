package acise.modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import acise.controlador.HibernateControler;
import acise.modelo.entidad.Enunciado;
import acise.modelo.entidad.Examen;
import acise.modelo.entidad.Respuesta;
import acise.modelo.entidad.Tag;
import acise.modelo.entidad.Usuario;

public class AccesoDatos {

	public static Set<Examen> recuperarExamen() {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		List<Examen> result1 = session.createQuery("from Examen").list();
		session.getTransaction().commit();
		Set<Examen> result = new HashSet<Examen>(result1);
		for (Iterator it = result.iterator(); it.hasNext();) {
			Examen enun = (Examen) it.next();
			Usuario usuario = (Usuario) enun.getUsuario();
			Set enunciados = enun.getEnunciados();
			for (Iterator itt = enunciados.iterator(); itt.hasNext();) {
				Enunciado enun2 = (Enunciado) itt.next();
				Set res = enun2.getRespuestas();
				for (Iterator resp = res.iterator(); resp.hasNext();) {
					Respuesta respuesta = (Respuesta) resp.next();
				}
			}
		}
		session.close();
		return result;
	}

	public static void modifyExamen(Examen examen) {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.update(examen);
		session.getTransaction().commit();
		session.close();
	}

	public static void addExamen(Examen examen) {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.save(examen);
		session.getTransaction().commit();
		session.close();
	}

	public static void deleteExam(Examen examen) {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.delete(examen);
		session.getTransaction().commit();
		session.close();
	}

	public static Set<Enunciado> recuperarEnunciados() {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		List<Enunciado> result1 = session.createQuery("from Enunciado").list();
		session.getTransaction().commit();
		Set<Enunciado> result = new HashSet<Enunciado>(result1);
		for (Iterator it = result.iterator(); it.hasNext();) {
			Enunciado enun = (Enunciado) it.next();
			Set respuestas = enun.getRespuestas();
			Set tag = enun.getTags();
			for (Iterator itt = tag.iterator(); itt.hasNext();) {
				Tag tagg = (Tag) itt.next();
			}
			for (Iterator it1 = respuestas.iterator(); it1.hasNext();) {
				Respuesta respuesta = (Respuesta) it1.next();

			}
		}
		session.close();
		return result;
	}

	public static void deleteEnunciados(Enunciado enunciado) {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.delete(enunciado);
		session.getTransaction().commit();
		session.close();
	}

	public static void modifyEnunciado(Enunciado enunciado) {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.update(enunciado);
		session.getTransaction().commit();
		session.close();
	}

	public static void addEnunciado(Enunciado enunciado) {
		Session session = HibernateControler.openHibernateSession();
		session.beginTransaction();
		session.save(enunciado);
		session.getTransaction().commit();
		session.close();
	}

}
