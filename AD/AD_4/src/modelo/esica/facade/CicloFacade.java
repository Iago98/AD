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
import modelo.esica.vo.CicloVO;

/**
 * @author Iago
 *
 */
public class CicloFacade {
	private static Connection conectaBD() throws ClassNotFoundException, SQLException {
		Class.forName(Constantes.nombre);
		Connection conexion = DriverManager.getConnection(Constantes.url, Constantes.nameDB, Constantes.contraseña);
		return conexion;

	}

	public static ArrayList<CicloVO> recuperarCiclos() throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		Statement s = conexion.createStatement();
		ResultSet miRes = s.executeQuery(MiSQL.selectAllCiclos);
		ArrayList<CicloVO> listaCiclos = new ArrayList<CicloVO>();

		while (miRes.next()) {

			CicloVO aux = new CicloVO();

			aux.setId(miRes.getInt("id"));
			aux.setNombre(miRes.getString("nombre"));
			aux.setNivel(miRes.getString("nivel"));
			aux.setCurso(miRes.getInt("curso"));

			listaCiclos.add(aux);

		}
		miRes.close();
		s.close();
		conexion.close();

		return listaCiclos;

	}

	
	public static void agregarCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {
		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.insertCiclo);

		s.setString(1, ciclo.getNombre());
		s.setString(2, ciclo.getNivel());
		s.setInt(3, ciclo.getCurso());

		s.executeUpdate();
		s.close();
		conexion.close();

	}

	public static void modificarCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {
		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.updateCiclo);

		s.setString(1, ciclo.getNombre());
		s.setString(2, ciclo.getNivel());
		s.setInt(3, ciclo.getCurso());
		s.setInt(4, ciclo.getId());

		s.executeUpdate();
		s.close();
		conexion.close();

	}

	/**
	 * @param ciclo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void eliminarCiclo(CicloVO ciclo) throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.deleteCiclo);

		s.setInt(1, ciclo.getId());

		s.executeUpdate();
		s.close();
		conexion.close();

	}
}