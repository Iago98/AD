package pfc.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pfc.entidad.Menu;
import pfc.entidad.RegistroCliente;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;

public class Pruebas {
	public static SessionFactory factory;

	public static void main(String[] args) {
		
//		RegistroCliente cliente = new RegistroCliente();
//		cliente.setLogin("iago98");
//		cliente.setNombre("iago");
//		cliente.setContrasenha("9");
//		Boolean bool=AccesoDatos.isLoginCliente(cliente);
		RegistroRestaurante res= new RegistroRestaurante();
		res.setLogin("iago_98");
		res.setContrasenha("a9");
		Boolean bool=AccesoDatos.isLoginRestaurante(res);
		
		System.out.println(bool.toString());

//		RegistroCliente reg = new RegistroCliente();
//		
//		reg.setLogin("iago98");
//		reg.setNombre("iago");
//		reg.setContrasenha("9");
//		
//		AccesoDatos.addLoginCliente(reg);
//		
//		Menu menu =new Menu();
//		menu.setDescripcion("primer plato:arroz");
//		menu.setTitulo("marisquiño");
//		menu.setRestaurante(reg);
//		
//		AccesoDatos.addMenu(menu);
		
	}

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
