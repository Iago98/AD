package esica.modelo.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CursanVO {

	private ArrayList<CursaVO> listaCursa = new ArrayList<CursaVO>();

	// Getter and Setters
	@XmlElement

	public ArrayList<CursaVO> getlistaCursa() {
		return listaCursa;
	}

	public void setListaCursa(ArrayList<CursaVO> listaCursa) {
		this.listaCursa = listaCursa;
	}

}
