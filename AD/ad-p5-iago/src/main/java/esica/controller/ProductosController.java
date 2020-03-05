package esica.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

import esica.modelo.facade.ProductoFacade;
import esica.modelo.vo.ProductoVO;
import esica.ui.ListaRef;
import esica.ui.ProductosUI;

public class ProductosController extends ProductosUI {

	@Override
	protected void agregarProducto() {
		BigDecimal big = new BigDecimal(getPrecio());
		ProductoVO producto = new ProductoVO();
		producto.setCantidad(Integer.valueOf(getCantidad()));
		producto.setPrecio(big);
		producto.setDescripcion((getDescripcion()));
		producto.setNombre(getNombre());
		producto.setReferencia(getReferencia());

		ProductoFacade.addOrModProduct(producto);
	}

	@Override
	protected void listarProducto() {

		
		ListaRef list= new ListaRef(null);

	}

	@Override
	protected void eliminarProducto() {
		
		int id=Integer.valueOf(getId());
		
		List<ProductoVO> lista=ProductoFacade.recuperar();
		ProductoFacade.deleteProduct(lista.get(id));
		
		
	}

	@Override
	protected void listaProductoRef() {
		ListaRef list= new ListaRef(getReferencia());
		
		
	}

	@Override
	protected void crearXML() {
		try {
			ProductoFacade.escribirXml();
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null,"No se ha podido recuperar","Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	@Override
	protected void importarXML() {
		try {
			ProductoFacade.importarXml(getRuta());
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null,"No se ha podido importar","Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
