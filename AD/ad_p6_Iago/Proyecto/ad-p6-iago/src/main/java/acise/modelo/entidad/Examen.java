package acise.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Examen implements Serializable{
	
	private Date fecha;
	private Usuario usuario;
	private Set<Enunciado> enunciados;
	private Integer id;
	private Float nota;
	private Integer incorrectas;
	private Integer noRespondidas;
	private Integer correctas;
	private float tiempo;
	
	
	public Examen() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public Integer getIncorrectas() {
		return incorrectas;
	}

	public void setIncorrectas(Integer incorrectas) {
		this.incorrectas = incorrectas;
	}

	public Integer getNoRespondidas() {
		return noRespondidas;
	}

	public void setNoRespondidas(Integer noRespondidas) {
		this.noRespondidas = noRespondidas;
	}

	public Integer getCorrectas() {
		return correctas;
	}

	public void setCorrectas(Integer correctas) {
		this.correctas = correctas;
	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Enunciado> getEnunciados() {
		return enunciados;
	}

	public void setEnunciados(Set<Enunciado> enunciados) {
		this.enunciados = enunciados;
	}
	
	
	
	
}
