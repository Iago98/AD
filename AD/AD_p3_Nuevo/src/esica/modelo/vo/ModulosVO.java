package esica.modelo.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModulosVO {
	
	
	private ArrayList<ModuloVO> listaModulo= new ArrayList<ModuloVO>();

	// Getter and Setters
	@XmlElement
	public ArrayList<ModuloVO> getListaModulo() {
		return listaModulo;
	}

	public void setListaModulo(ArrayList<ModuloVO> listaModulo) {
		this.listaModulo = listaModulo;
	}
	
}