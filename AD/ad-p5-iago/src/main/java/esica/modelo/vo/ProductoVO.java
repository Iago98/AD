package esica.modelo.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
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
	

	@XmlElement
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
	@XmlTransient
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	@XmlElement
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@XmlElement
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	

}
