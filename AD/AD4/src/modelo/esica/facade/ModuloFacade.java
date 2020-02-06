package modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.esica.Constantes;
import modelo.esica.MiSQL;
import modelo.esica.vo.ModuloVO;

public class ModuloFacade {

	public static void agregarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {

		if (comprobarCampoValido(modulo.getNombre()) == 0
				|| comprobarCampoValido(String.valueOf(modulo.getCurso())) == 0
				|| comprobarCampoValido(String.valueOf(modulo.getHoras())) == 0) {
			JOptionPane.showMessageDialog(null, "Campo/s vacio/s", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (comprobarCampoValido(modulo.getNombre()) == 2 || modulo.getNombre().length() > 60
				|| comprobarCampoValido(String.valueOf(modulo.getCurso())) == 1
				|| String.valueOf(modulo.getCurso()).length() > 1
				|| comprobarCampoValido(String.valueOf(modulo.getHoras())) == 1
				|| String.valueOf(modulo.getHoras()).length() > 3) {
			JOptionPane.showMessageDialog(null, "Campo/s mal rellenado/s", "Error", JOptionPane.ERROR_MESSAGE);
		} else {

			Connection conexion = conectaBD();
			PreparedStatement s = conexion.prepareStatement(MiSQL.insertModulo);

			s.setString(1, modulo.getNombre());
			s.setInt(2, modulo.getCurso());
			s.setInt(3, modulo.getHoras());
			s.setInt(4, modulo.getCiclo());

			s.executeUpdate();
			s.close();
			conexion.close();

		}

	}

	/*
	 * DEVUELVE 99 SI ERROR DEVUELVE 0 SI VACIO DEVUELVE 1 SI LETRA DEVUELVE 2 SI
	 * NUMERO
	 */
	public static int comprobarCampoValido(String campo) {
		int error = 99;
		if (campo.trim().equals("")) {
			return 0;
		} else if (!campo.trim().equals("")) {
			if (isNum(campo)) {
				return 2;
			} else if (!isNum(campo)) {
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

	public static ArrayList<ModuloVO> recuperarModulo() throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		Statement s = conexion.createStatement();
		ResultSet miRes = s.executeQuery(MiSQL.selectAllModulo);
		ArrayList<ModuloVO> listaModulos = new ArrayList<ModuloVO>();

		while (miRes.next()) {

			ModuloVO aux = new ModuloVO();

			aux.setId(miRes.getInt("id"));
			aux.setNombre(miRes.getString("nombre"));
			aux.setCurso(miRes.getInt("curso"));
			aux.setHoras(miRes.getInt("horas"));
			aux.setCiclo(miRes.getInt("id_ciclo"));

			listaModulos.add(aux);

		}
		miRes.close();
		s.close();
		conexion.close();

		return listaModulos;

	}

	public static void modificarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {
		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.updateModulo);

		s.setInt(3, modulo.getHoras());
		s.setString(1, modulo.getNombre());
		s.setInt(2, modulo.getCurso());
		s.setInt(4, modulo.getCiclo());
		s.setInt(5, modulo.getId());

		s.executeUpdate();
		s.close();
		conexion.close();

	}

	public static void eliminarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.deleteModulo);

		s.setInt(1, modulo.getId());

		s.executeUpdate();
		s.close();
		conexion.close();

	}

	private static Connection conectaBD() throws ClassNotFoundException, SQLException {
		Class.forName(Constantes.nombre);
		Connection conexion = DriverManager.getConnection(Constantes.url, Constantes.nameDB, Constantes.contraseña);
		return conexion;

	}

}
