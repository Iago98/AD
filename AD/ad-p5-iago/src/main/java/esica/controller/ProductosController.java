package esica.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import esica.modelo.facade.ProductoFacade;
import esica.modelo.vo.ProductoVO;
import esica.ui.Lista;
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

		
		Lista list= new Lista();

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
}
