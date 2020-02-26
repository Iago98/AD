package esica.modelo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductoVO implements Serializable{

	@Override
	public String toString() {
		return " nombre=" + nombre + ", referencia=" + referencia + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", precio=" + precio;
	}
	private int id;
	private String nombre;
	private String referencia;
	private String descripcion;
	private int cantidad;
	private BigDecimal precio;
	


	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public ProductoVO() {
		super();
	}
	
	public ProductoVO(int id, String nombre, String referencia, String descripcion, int cantidad, BigDecimal precio) {
		this.id = id;
		this.nombre = nombre;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	

}
