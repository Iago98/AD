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
import modelo.esica.vo.ModuloVO;

public class ModuloFacade {

	public static void agregarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {
		Connection conexion =conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.insertModulo);
		
		
		s.setString(1, modulo.getNombre());
		s.setInt(2, modulo.getCurso());
		s.setInt(3, modulo.getHoras());
		s.setInt(4, modulo.getCiclo());
		
		s.executeUpdate();
		s.close();
		conexion.close();
		
	}
	
	public static ArrayList<ModuloVO> recuperarModulo() throws ClassNotFoundException, SQLException{
		
		Connection conexion =conectaBD();
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
		Connection conexion =conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.updateModulo);
		
		
		
		s.setInt(1, modulo.getHoras());
		s.setString(2, modulo.getNombre());
		s.setInt(3, modulo.getCurso());
		s.setInt(4, modulo.getCiclo());
		s.setInt(5, modulo.getId());
		
		s.executeUpdate();
		s.close();
		conexion.close();
		
		
	}
	public static void eliminarModulo(ModuloVO modulo) throws ClassNotFoundException, SQLException {
		
		Connection conexion =conectaBD();
		PreparedStatement s = conexion.prepareStatement(MiSQL.deleteModulo);
		
		
		
		s.setInt(1, modulo.getId());
		
		s.executeUpdate();
		s.close();
		conexion.close();
		
		
	}
	
	private static Connection conectaBD() throws ClassNotFoundException, SQLException {
		Class.forName(Constantes.nombre);
		Connection conexion = DriverManager.getConnection(Constantes.url,Constantes.nameDB,Constantes.contraseña);
		return conexion;
		
		
	}
	
	
	
}
