package pfc.entidad;

import java.io.Serializable;

public class Menu implements Serializable {

	private Integer id;
	private String titulo;
	private String descripcion;
	private RegistroRestaurante restaurante;
	
	public Menu() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RegistroRestaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RegistroRestaurante restaurante) {
		this.restaurante = restaurante;
	}

}
