package pfc.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import pfc.controlador.Pruebas;
import pfc.entidad.Menu;
import pfc.entidad.RegistroCliente;
import pfc.entidad.RegistroRestaurante;

public class AccesoDatos {
	public static void addLoginRestaurante(RegistroRestaurante login) {
		Session session = Pruebas.openHibernateSession();
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();
		session.close();
	}

	public static Boolean existRestaurant(RegistroRestaurante rg) {
		List<RegistroRestaurante> reg = recuperarRegistroRestaurante(rg);

		if (reg.isEmpty()) {
			return false;
		}
		return true;

	}

	public static Boolean existClient(RegistroCliente rg) {
		List<RegistroCliente> reg = recuperarRegistroCliente(rg);

		if (reg.isEmpty()) {
			return false;
		}
		return true;

	}

	public static void addLoginCliente(RegistroCliente login) {
		Session session = Pruebas.openHibernateSession();
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();
		session.close();
	}

	public static void addMenu(Menu menu) {
		Session session = Pruebas.openHibernateSession();
		session.beginTransaction();
		session.save(menu);
		session.getTransaction().commit();
		session.close();
	}

	public static Boolean isLoginRestaurante(RegistroRestaurante rgRestaurante) {

		List<RegistroRestaurante> reg = recuperarRegistroRestaurante(rgRestaurante);
		if (!reg.isEmpty()) {
			if (reg.get(0).getLogin().equals(rgRestaurante.getLogin())
					&& reg.get(0).getContrasenha().equals(rgRestaurante.getContrasenha())) {
				return true;
			}
		}
		return false;

	}

	public static Boolean isLoginCliente(RegistroCliente rgCliente) {
		List<RegistroCliente> reg = recuperarRegistroCliente(rgCliente);
		if (!reg.isEmpty()) {
			if (reg.get(0).getLogin().equals(rgCliente.getLogin())
					&& reg.get(0).getContrasenha().equals(rgCliente.getContrasenha())) {
				return true;
			}
		}
		return false;

	}

	public static List<RegistroCliente> recuperarRegistroCliente(RegistroCliente rgCliente) {
		Session session = Pruebas.openHibernateSession();
		session.beginTransaction();
		String str = "FROM RegistroCliente WHERE login=:login";
		Query query = session.createQuery(str);
		query.setParameter("login", rgCliente.getLogin());
		List<RegistroCliente> result = new ArrayList<RegistroCliente>(query.list());
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public static List<RegistroRestaurante> recuperarRegistroRestaurante(RegistroRestaurante rgRestaurante) {
		Session session = Pruebas.openHibernateSession();
		session.beginTransaction();
		String str = "FROM RegistroRestaurante WHERE login=:login";
		Query query = session.createQuery(str);
		query.setParameter("login", rgRestaurante.getLogin());
		List<RegistroRestaurante> result = new ArrayList<RegistroRestaurante>(query.list());
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
