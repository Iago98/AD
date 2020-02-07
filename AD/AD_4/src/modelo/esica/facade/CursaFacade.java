package modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.esica.Constantes;
import modelo.esica.MiSQL;
import modelo.esica.vo.CursaVO;

public class CursaFacade {

	private static Connection conectaBD() throws ClassNotFoundException, SQLException {
		Class.forName(Constantes.nombre);
		Connection conexion = DriverManager.getConnection(Constantes.url, Constantes.nameDB, Constantes.contraseña);
		return conexion;

	}

	public static void agregarCursa(CursaVO cursa) throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.insertCursa);

		s.setString(1, cursa.getAnho());
		s.setInt(2, cursa.getId_modulo());
		s.setString(3, cursa.getDni());
		s.setInt(4, cursa.getNota());

		s.executeUpdate();
		s.close();
		conexion.close();

	}

	public static ArrayList<CursaVO> recuperarCursa() throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		Statement s = conexion.createStatement();
		ResultSet miRes = s.executeQuery(MiSQL.selectAllCursa);
		ArrayList<CursaVO> listaCursa = new ArrayList<CursaVO>();

		while (miRes.next()) {

			CursaVO aux = new CursaVO();

			aux.setAnho(miRes.getString("ANHO"));
			aux.setId_modulo(miRes.getInt("ID_MODULO"));
			aux.setDni(miRes.getString("DNI"));
			aux.setNota(miRes.getInt("NOTA"));

			listaCursa.add(aux);

		}
		miRes.close();
		s.close();
		conexion.close();

		return listaCursa;

	}

	public static void modificarCursa(CursaVO cursa) throws ClassNotFoundException, SQLException {
		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.updateCursa);

		s.setString(1, cursa.getAnho());
		s.setInt(2, cursa.getNota());
		s.setString(3, cursa.getDni());
		s.setInt(4, cursa.getId_modulo());
		
		s.executeUpdate();
		s.close();
		conexion.close();

	}

	public static void eliminarCursa(CursaVO cursa) throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.deleteCursa);

		s.setInt(2, cursa.getId_modulo());
		s.setString(1, cursa.getDni());


		s.executeUpdate();
		s.close();
		conexion.close();

	}

}
