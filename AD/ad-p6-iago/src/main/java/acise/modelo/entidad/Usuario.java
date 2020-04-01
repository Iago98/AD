package acise.modelo.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Usuario implements Serializable {
	
	private String clave;
	private String dni;
	private Set<Examen> examenes;
	
	public Usuario() {
		
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Set<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}
	
	

	

}
