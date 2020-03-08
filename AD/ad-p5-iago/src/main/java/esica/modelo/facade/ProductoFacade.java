package esica.modelo.facade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.DocumentHelper;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.sun.xml.txw2.Document;

import esica.controller.HibernateController;
import esica.modelo.vo.ProductoVO;
import esica.modelo.vo.ProductosVO;

public class ProductoFacade {

	public static void addOrModProduct(ProductoVO producto) {

		Session session = HibernateController.openHibernateSession();
		session.beginTransaction();
		session.saveOrUpdate(producto);
		session.getTransaction().commit();
		session.close();
	}

	public static List<ProductoVO> recuperar() {
		Session session = HibernateController.openHibernateSession();
		session.beginTransaction();
		List<ProductoVO> result = session.createQuery("from ProductoVO").list();
		session.getTransaction().commit();
		session.close();
		result.toString();
		return result;
	}

	public static void deleteProduct(ProductoVO producto) {
		Session session = HibernateController.openHibernateSession();
		session.beginTransaction();
		session.delete(producto);
		session.getTransaction().commit();
	}
	
	public static List<ProductoVO> verProductoRefe(String ref) {

		List<ProductoVO> listaCoincidentes = new ArrayList<ProductoVO>();
		try {
			List<ProductoVO> lista=recuperar();
			for(int x=0;x<lista.size();x++) {
				
				if(lista.get(x).getReferencia().equals(ref)) {
					listaCoincidentes.add(lista.get(x));
				}
			}
			System.out.println(listaCoincidentes.toString());
		}catch (Exception e) {
			e.getStackTrace();
			JOptionPane.showMessageDialog(null, "Ref no encontrada");		}
		return listaCoincidentes;
		 
		
		
	}

	public static void escribirXml() throws JAXBException {
		List<ProductoVO> result=recuperar();
		ProductosVO productos = new ProductosVO();
		ArrayList<ProductoVO> lista=new ArrayList<ProductoVO>();
		for(int x=0;x<result.size();x++) {
			lista.add(result.get(x));
			
		}

		productos.setListaProducto(lista);
		JAXBContext context = JAXBContext.newInstance(ProductosVO.class);

		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.marshal(productos, new File("Producto.xml"));

		
		
		
		}
	public static void importarXml(String ruta) throws JAXBException {
		

		File file = new File(ruta);
		ProductosVO productos = null;
		if (!file.exists()) {
			try {

				file.createNewFile();
				JAXBContext context = JAXBContext.newInstance(ProductosVO.class);
				ProductosVO pdcto = new ProductosVO();

				Marshaller marsh = context.createMarshaller();

				marsh.marshal(pdcto, new File(ruta));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		JAXBContext context = JAXBContext.newInstance(ProductosVO.class);
		// Objeto a serializar en XML

		Unmarshaller unMarsh = context.createUnmarshaller();

		productos = (ProductosVO) unMarsh.unmarshal(file);
		ArrayList<ProductoVO> listaModulos = productos.getListaProducto();
		List<ProductoVO>listaP= new ArrayList<ProductoVO>();
		for(int x=0;x<listaModulos.size();x++) {
			listaP.add(listaModulos.get(x));
		}
		for(int i=0;i<listaP.size();i++) {
			addOrModProduct(listaP.get(i));

		}
	
}
		 
		
	}