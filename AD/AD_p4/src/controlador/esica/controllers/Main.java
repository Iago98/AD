package controlador.esica.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import modelo.esica.Constantes;

public class Main {
	
	
	public static void main(String[] args) {
		getProps();
		ModulosController mc = new ModulosController();
		mc.show();
	}
	
	protected static void getProps() {
	Properties props = new Properties();
	try {
		props.load(new FileInputStream("conect.props"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Constantes.contraseña=props.getProperty("password");
		
		Constantes.nombre=props.getProperty("name");
		

		Constantes.nameDB=props.getProperty("nameDB");
		

		Constantes.url=props.getProperty("url");
 
} 
	}