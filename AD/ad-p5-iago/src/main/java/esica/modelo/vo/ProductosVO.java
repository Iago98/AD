package esica.modelo.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ProductosVO {

	private ArrayList<ProductoVO> listaProducto= new ArrayList<ProductoVO>();

	// Getter and Setters
	@XmlElement
	public ArrayList<ProductoVO> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(ArrayList<ProductoVO> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
}