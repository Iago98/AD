package modelo.esica.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.esica.Constantes;
import modelo.esica.MiSQL;
import modelo.esica.vo.AlumnoVO;


public class AlumnoFacade {

	private static Connection conectaBD() throws ClassNotFoundException, SQLException {
		Class.forName(Constantes.nombre);
		Connection conexion = DriverManager.getConnection(Constantes.url, Constantes.nameDB, Constantes.contraseña);
		return conexion;

	}

	public static ArrayList<AlumnoVO> recuperarAlumnoVO() throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		Statement s = conexion.createStatement();
		ResultSet miRes = s.executeQuery(MiSQL.selectAllAlumno);
		ArrayList<AlumnoVO> listaCiclos = new ArrayList<AlumnoVO>();

		while (miRes.next()) {

			AlumnoVO aux = new AlumnoVO();

			aux.setDni(miRes.getString("dni"));
			aux.setNombre(miRes.getString("nombre"));
			aux.setApellido1(miRes.getString("primerapellido"));
			aux.setApellido2(miRes.getString("segundoapellido"));
			aux.setTelefono(miRes.getString("telefono"));
			aux.setFnacimiento(miRes.getDate("fechanacimiento"));
			
			
			listaCiclos.add(aux);

		}
		miRes.close();
		s.close();
		conexion.close();

		return listaCiclos;

	}

	
	public static void agregarAlumno(AlumnoVO alumno) throws ClassNotFoundException, SQLException {
		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.insertAlumno);

		s.setString(1, alumno.getDni());
		s.setString(2, alumno.getNombre());
		s.setString(3, alumno.getApellido1());
		s.setString(4, alumno.getApellido2());
		s.setString(5, alumno.getTelefono());
		s.setDate(6, alumno.getFnacimiento());

		try {
			s.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "DNI ya registrado en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		s.close();
		conexion.close();

	}

	public static void modificarModulo(AlumnoVO alumno) throws ClassNotFoundException, SQLException {
		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.updateAlumno);

		s.setString(1, alumno.getDni());
		s.setString(2, alumno.getNombre());
		s.setString(3, alumno.getApellido1());
		s.setString(4, alumno.getApellido2());
		s.setString(5, alumno.getTelefono());
		s.setDate(6, alumno.getFnacimiento());
		
		
		s.executeUpdate();
		s.close();
		conexion.close();

	}

	/**
	 * @param alumno
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void eliminarModulo(AlumnoVO alumno) throws ClassNotFoundException, SQLException {

		Connection conexion = conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.deleteAlumno);

		s.setString(1, alumno.getDni());

		s.executeUpdate();
		s.close();
		conexion.close();

	}

}
