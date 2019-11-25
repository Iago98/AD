package esica.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import esica.modelo.facade.ModuloFacade;
import esica.modelo.vo.ModuloVO;
import esica.vista.ModulosUI;

public class ModulosController extends ModulosUI {

	@Override
	protected void agregarModulo() {
		ModuloVO moduloVO = new ModuloVO();

		moduloVO.setNombre(getNombre());
		moduloVO.setCurso(getCurso());
		moduloVO.setHoras(getHoras());
		moduloVO.setCiclo(getCicloId());

		try {
			ModuloFacade.agregarModulo(moduloVO);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void editarModulo() {
		ModuloVO moduloVO = new ModuloVO();

		moduloVO.setNombre(getNombre());
		moduloVO.setCurso(getCurso());
		moduloVO.setHoras(getHoras());
		moduloVO.setId(getId());
		moduloVO.setCiclo(getCicloId());
		try {
			ModuloFacade.modificarModulo(moduloVO);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void eliminarModulo() {

		ModuloVO moduloVO = new ModuloVO();

		moduloVO.setNombre(getNombre());
		moduloVO.setCurso(getCurso());
		moduloVO.setHoras(getHoras());
		moduloVO.setId(getId());
		moduloVO.setCiclo(getCicloId());

		try {
			ModuloFacade.borrarModulo(moduloVO);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected List<String[]> transformarListaVO() {
		ArrayList<String[]> dam = new ArrayList<String[]>();
		ArrayList<ModuloVO> modulosLista = new ArrayList<ModuloVO>();
		try {
			modulosLista = ModuloFacade.recuperar();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		for (int x = 0; x < modulosLista.size(); x++) {
			String[] arr = { modulosLista.get(x).getNombre(), Integer.toString(modulosLista.get(x).getCiclo()),
					modulosLista.get(x).getCurso(), modulosLista.get(x).getHoras(),
					Integer.toString(modulosLista.get(x).getId()) };
			dam.add(arr);
		}

		return (dam);
	}

}