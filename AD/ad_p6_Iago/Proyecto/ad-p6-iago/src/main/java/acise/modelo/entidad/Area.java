package acise.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

public class Area implements Serializable {

	private Set<Enunciado> enunciados;
	private Integer id;
	private String area;

	public Area() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Set<Enunciado> getEnunciados() {
		return enunciados;
	}

	public void setEnunciados(Set<Enunciado> enunciados) {
		this.enunciados = enunciados;
	}

}
