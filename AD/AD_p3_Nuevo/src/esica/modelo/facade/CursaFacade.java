package esica.modelo.facade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import esica.modelo.vo.CursaVO;
import esica.modelo.vo.CursanVO;

public class CursaFacade {
	final static String RUTA = "Cursan.xml";

	public static ArrayList<CursaVO> recuperar() throws JAXBException {

		File file = new File(RUTA);
		CursanVO cursan = null;
		if (!file.exists()) {
			try {

				file.createNewFile();
				JAXBContext context = JAXBContext.newInstance(CursanVO.class);
				CursanVO crsa = new CursanVO();

				Marshaller marsh = context.createMarshaller();

				marsh.marshal(crsa, new File(RUTA));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		JAXBContext context = JAXBContext.newInstance(CursanVO.class);
		// Objeto a serializar en XML

		Unmarshaller unMarsh = context.createUnmarshaller();

		cursan = (CursanVO) unMarsh.unmarshal(file);

		ArrayList<CursaVO> listaCursan = cursan.getlistaCursa();

		return listaCursan;

	}

	public static void escribirListaXML(ArrayList<CursaVO> cursosLista) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(CursanVO.class);

		CursanVO cursan = new CursanVO();
		cursan.setListaCursa(cursosLista);
		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.marshal(cursan, new File(RUTA));

	}

	public static void agregarCursa(CursaVO cursa) throws JAXBException {
		boolean bool=false;
		ArrayList<CursaVO> cursanLista = new ArrayList<CursaVO>();
		cursanLista = recuperar();
		
		if (!cursa.getDni().equals(null)&& !(cursa.getId()==null)) {

			for (int x = 0; x < cursanLista.size(); x++) {

				if (cursa.getDni().equals(cursanLista.get(x).getDni())||cursa.getId()==cursanLista.get(x).getId()) {
					bool = true;
				}
			}
			if (bool == false) {
				cursanLista.add(cursa);
				escribirListaXML(cursanLista);
			}
		}
		

	}

	public static void modificarCursa(CursaVO cursa) throws JAXBException {

		ArrayList<CursaVO> cursanLista = new ArrayList<CursaVO>();
		cursanLista = recuperar();

		for (int i = 0; i < cursanLista.size(); i++) {
			if (cursa.getId() == cursanLista.get(i).getId() && cursa.getDni().equals(cursanLista.get(i).getDni())) {
				cursanLista.get(i).setAnho(cursa.getAnho());
				cursanLista.get(i).setNota(cursa.getNota());

			}

		}
		escribirListaXML(cursanLista);

	}

	public static void borrarCursa(CursaVO cursa) throws JAXBException {

		ArrayList<CursaVO> CursanLista = new ArrayList<CursaVO>();
		CursanLista = recuperar();

		for (int x = 0; x < CursanLista.size(); x++) {
			if (cursa.getDni().equals(CursanLista.get(x).getDni()) && cursa.getId() == CursanLista.get(x).getId()) {

				CursanLista.remove(x);
				escribirListaXML(CursanLista);

			}

		}

	}

	

}