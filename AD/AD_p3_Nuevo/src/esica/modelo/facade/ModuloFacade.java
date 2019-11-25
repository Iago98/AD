package esica.modelo.facade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import esica.modelo.vo.ModuloVO;
import esica.modelo.vo.ModulosVO;

public class ModuloFacade {
	private final static String RUTA = "Modulos.xml";

	public static ArrayList<ModuloVO> recuperar() throws JAXBException {

		File file = new File(RUTA);
		ModulosVO modulos = null;
		if (!file.exists()) {
			try {

				file.createNewFile();
				JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
				ModulosVO mdlo = new ModulosVO();

				Marshaller marsh = context.createMarshaller();

				marsh.marshal(mdlo, new File(RUTA));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
		// Objeto a serializar en XML

		Unmarshaller unMarsh = context.createUnmarshaller();

		modulos = (ModulosVO) unMarsh.unmarshal(file);
		ArrayList<ModuloVO> listaModulos = modulos.getListaModulo();

		return listaModulos;

	}

	public static void escribirListaXML(ArrayList<ModuloVO> modulosLista) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(ModulosVO.class);

		ModulosVO modulos = new ModulosVO();
		modulos.setListaModulo(modulosLista);
		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.marshal(modulos, new File(RUTA));

	}

	public static void agregarModulo(ModuloVO modulo) throws JAXBException {

		ArrayList<ModuloVO> ModulosLista = new ArrayList<ModuloVO>();
		ModulosLista = recuperar();
		modulo.setId(getNuevoId(ModulosLista));
		ModulosLista.add(modulo);
		escribirListaXML(ModulosLista);

	}

	public static void modificarModulo(ModuloVO modulo) throws JAXBException {

		ArrayList<ModuloVO> modulosLista = new ArrayList<ModuloVO>();
		modulosLista = recuperar();

		for (int i = 0; i < modulosLista.size(); i++) {
			if (modulo.getId() == modulosLista.get(i).getId()) {
				modulosLista.get(i).setNombre(modulo.getNombre());
				modulosLista.get(i).setHoras(modulo.getHoras());
				modulosLista.get(i).setCurso(modulo.getCurso());
				modulosLista.get(i).setCiclo(modulo.getCiclo());

			}

		}
		escribirListaXML(modulosLista);

	}

	private static int getNuevoId(ArrayList<ModuloVO> modulosLista) {
		int mayor = 0;
		if (modulosLista.size() > 0) {
			for (int x = 0; x < modulosLista.size(); x++) {
				int numId = modulosLista.get(x).getId();
				if (mayor <= numId) {
					mayor = numId;
					mayor++;
				}
			}
		}

		return (mayor);
	}

	public static void borrarModulo(ModuloVO modulo) throws JAXBException {

		ArrayList<ModuloVO> modulosLista = new ArrayList<ModuloVO>();
		modulosLista = recuperar();

		for (int x = 0; x < modulosLista.size(); x++) {
			if (modulo.getId() == modulosLista.get(x).getId()) {

				modulosLista.remove(x);
				escribirListaXML(modulosLista);

			}

		}

	}

	

}
