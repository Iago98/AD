package modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.esica.Constantes;
import modelo.esica.MiSQL;
import modelo.esica.vo.CicloVO;

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
}