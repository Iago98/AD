package controlador.esica.controllers;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.esica.facade.CicloFacade;
import modelo.esica.facade.ModuloFacade;
import modelo.esica.vo.CicloVO;
import modelo.esica.vo.ModuloVO;
import vista.esica.views.ModulosUI;

public class ModulosController extends ModulosUI{

	@Override
	protected void agregarModulo() {
		ModuloVO modulo = new ModuloVO();
			if(comprobarCampoValido(getNombre())==0||comprobarCampoValido(getCurso())==0||comprobarCampoValido(getHoras())==0) {
				JOptionPane.showMessageDialog(null,"Campo/s vacio/s","Error",JOptionPane.ERROR_MESSAGE);
			}else if(comprobarCampoValido(getNombre())==2||getNombre().length()>60||comprobarCampoValido(getCurso())==1||getCurso().length()>1||comprobarCampoValido(getHoras())==1||getHoras().length()>3) {
				JOptionPane.showMessageDialog(null,"Campo/s mal rellenado/s","Error",JOptionPane.ERROR_MESSAGE);
			}else {
				
				modulo.setNombre(getNombre());
				modulo.setCurso(Integer.valueOf(getCurso()));
				modulo.setHoras(Integer.valueOf(getHoras()));
				modulo.setCiclo(getCicloId());
				try {
					ModuloFacade.agregarModulo(modulo);
				} catch (ClassNotFoundException | SQLIntegrityConstraintViolationException e) {
					JOptionPane.showMessageDialog(null,"Usuario no insertado, ID repetido","Error",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		
		
		
	}
	
	/*
	 *DEVUELVE 99 SI ERROR
	 *DEVUELVE 0 SI VACIO
	 *DEVUELVE 1 SI LETRA
	 *DEVUELVE 2 SI NUMERO
	 */
	public int comprobarCampoValido(String campo) {
		int error=99;
		if(campo.trim().equals("")) {
			return 0;
		}else if(!campo.trim().equals("")) {
			if(isNum(campo)) {
				return 2;
			}else if(!isNum(campo)) {
				return 1;
			}
		}
		
		return error;
	}
 private static boolean isNum(String valor) {
		try {
			Integer.valueOf(valor);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	protected void editarModulo() {

		ModuloVO modulo = new ModuloVO();
		modulo.setNombre(getNombre());
		modulo.setCurso(Integer.valueOf(getCurso()));
		modulo.setHoras(Integer.valueOf(getHoras()));
		modulo.setCiclo(getCicloId());
		modulo.setId(getId());

		
		try {
			ModuloFacade.modificarModulo(modulo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void eliminarModulo() {
		
		ModuloVO modulo = new ModuloVO();
		modulo.setNombre(getNombre());
		modulo.setCurso(Integer.valueOf(getCurso()));
		modulo.setHoras(Integer.valueOf(getHoras()));
		modulo.setCiclo(getCicloId());
		modulo.setId(getId());

		
		try {
			ModuloFacade.eliminarModulo(modulo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	protected List<String[]> transformarListaVO() {
		//(String[]) donde cada elemento sea un array con {"Nombre","Ciclo","Curso","Horas","ID"}
		ArrayList<String[]> dam = new ArrayList<String[]>();
		ArrayList<ModuloVO> modulosLista = new ArrayList<ModuloVO>();
		
			try {
				modulosLista = ModuloFacade.recuperarModulo();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int x = 0; x < modulosLista.size(); x++) {
				String[] arr = { modulosLista.get(x).getNombre(), String.valueOf(modulosLista.get(x).getCiclo()), String.valueOf(modulosLista.get(x).getCurso()),
						String.valueOf(modulosLista.get(x).getHoras()),String.valueOf(modulosLista.get(x).getId())
						};
				dam.add(arr);
			}	
			
		return dam;
	}

	@Override
	protected void cargarComboCiclos() {

		 ArrayList<CicloVO> listaCiclos = new ArrayList<CicloVO>();
		 try {
			listaCiclos= CicloFacade.recuperarCiclos();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 for(int x=0;x<listaCiclos.size();x++) {
			 
			 addCiclo(listaCiclos.get(x).getId(), listaCiclos.get(x).getNombre());
			 
		 }
		
	}
	
	

}
