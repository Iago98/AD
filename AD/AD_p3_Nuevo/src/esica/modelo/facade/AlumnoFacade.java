package esica.modelo.facade;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import esica.modelo.vo.AlumnoVO;
import esica.modelo.vo.AlumnosVO;

public class AlumnoFacade {
	final static String RUTA = "Alumnos.xml";

	public static void main() {

	}

	// Recupera todos los XML que existen en "RUTA", sino crea un XML con la
	// estructura Alumno y luego la re
	public static ArrayList<AlumnoVO> recuperar() throws JAXBException {

		File file = new File(RUTA);
		AlumnosVO alumnos = null;
		if (!file.exists()) {
			try {

				file.createNewFile();
				JAXBContext context = JAXBContext.newInstance(AlumnosVO.class);
				AlumnosVO almno = new AlumnosVO();

				Marshaller marsh = context.createMarshaller();

				marsh.marshal(almno, new File(RUTA));

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		JAXBContext context = JAXBContext.newInstance(AlumnosVO.class);
		// Objeto a serializar en XML

		Unmarshaller unMarsh = context.createUnmarshaller();

		alumnos = (AlumnosVO) unMarsh.unmarshal(file);
		ArrayList<AlumnoVO> listaAlumnos = alumnos.getListaAlumno();

		return listaAlumnos;

	}

	public static void escribirListaXML(ArrayList<AlumnoVO> alumnosLista) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(AlumnosVO.class);

		AlumnosVO alumnos = new AlumnosVO();
		alumnos.setListaAlumno(alumnosLista);

		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.marshal(alumnos, new File(RUTA));

	}

	public static void agregarAlumno(AlumnoVO alumno) throws JAXBException {
		boolean bool = false;
		ArrayList<AlumnoVO> alumnosLista = new ArrayList<AlumnoVO>();
		alumnosLista = recuperar();
		if (!alumno.getDni().equals(null)) {

			for (int x = 0; x < alumnosLista.size(); x++) {

				if (alumno.getDni().equals(alumnosLista.get(x).getDni())) {
					bool = true;
				}
			}
			if (bool == false) {
				alumnosLista.add(alumno);
				escribirListaXML(alumnosLista);
			}
		}

	}

	public static void modificarAlumno(AlumnoVO alum) throws JAXBException {

		ArrayList<AlumnoVO> alumnosLista = new ArrayList<AlumnoVO>();
		alumnosLista = recuperar();

		for (int i = 0; i < alumnosLista.size(); i++) {
			if (alum.getDni().equals(alumnosLista.get(i).getDni())) {
				alumnosLista.get(i).setNombre(alum.getNombre());
				alumnosLista.get(i).setApellido1(alum.getApellido1());
				alumnosLista.get(i).setApellido2(alum.getApellido2());
				alumnosLista.get(i).setTelefono(alum.getTelefono());

			}

		}
		escribirListaXML(alumnosLista);

	}

	public static void borrarAlumno(AlumnoVO alumno) throws JAXBException {

		ArrayList<AlumnoVO> alumnosLista = new ArrayList<AlumnoVO>();
		alumnosLista = recuperar();

		for (int x = 0; x < alumnosLista.size(); x++) {
			if (alumno.getDni().equals(alumnosLista.get(x).getDni())) {

				alumnosLista.remove(x);
				escribirListaXML(alumnosLista);

			}

		}

	}

}