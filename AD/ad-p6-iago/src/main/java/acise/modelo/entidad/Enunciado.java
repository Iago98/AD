package acise.modelo.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Enunciado implements Serializable{
	
	private Integer id;
	private String enunciado;
	private Set<Examen> examenes;
	private Set<Respuesta> respuestas;
	private Set<Tag> tags;
	private Area area;
	
	public Enunciado() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Set<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Examen> examenes) {
		this.examenes = examenes;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	
	


	
	

}
