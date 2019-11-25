package esica.modelo.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlumnosVO {

	
	private ArrayList<AlumnoVO> listaAlumno= new ArrayList<AlumnoVO>();

	// Getter and Setters
	@XmlElement
	public ArrayList<AlumnoVO> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(ArrayList<AlumnoVO> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}
	
	
}

