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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.DocumentHelper;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.sun.xml.txw2.Document;

import esica.controller.HibernateController;
import esica.modelo.vo.ProductoVO;

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
	public static void escribirListaXML(ArrayList<ProductoVO> alumnosLista) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(ProductoVO.class);

		ProductoVO alumnos = new ProductoVO();

		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.marshal(alumnos, new File("DATABASE.xml"));

	}
	public static void escribirXml() {
		List<ProductoVO> result=recuperar();
		for ( int i=0; i<result.size(); i++ ) {
		    //add the customer data to the XML document
		    ProductoVO customer = (ProductoVO) result.get(i);
		    doc.add(customer);
		}
		 
		
	}
}
