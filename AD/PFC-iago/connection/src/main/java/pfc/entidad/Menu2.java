package pfc.entidad;

import java.io.Serializable;

public class Menu2 implements Serializable {

	private Integer id;
	private String titulo;
	private String descripcion;
	
	
	public Menu2() {

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

	@Override
	public String toString() {
		return "Menu [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", restaurante=" + 
				"]";
	}
	

}
