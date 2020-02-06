package modelo.esica;

public class MiSQL {

//	//CONSULTAS SQL MODULO
	public final static String insertModulo= "INSERT INTO modulo (id, nombre, curso, horas, id_ciclo) VALUES (SEQ_MODULO.NEXTVAL,?,?,?,?)";
	public final static String updateModulo= "UPDATE modulo SET nombre=?,curso=?,horas=?,id_ciclo=? WHERE id =?";
	public final static String selectAllModulo= "SELECT id, nombre, curso, horas, id_ciclo FROM modulo";
	public final static String deleteModulo= "DELETE FROM modulo WHERE id = ? ";
	
	//CONSULTA SQL CICLO
	public final static String selectAllCiclos= "SELECT id, nombre, nivel, curso FROM ciclo";
	public final static String insertCiclo= "INSERT INTO CICLO (ID, NOMBRE, NIVEL, CURSO) VALUES (SEQ_CICLO.NEXTVAL,?,?,?)";
	public final static String updateCiclo= "UPDATE CICLO SET NOMBRE = ?, NIVEL = ?, CURSO = ? WHERE ID =?";
	public final static String deleteCiclo= "DELETE FROM CICLO WHERE ID = ?";

//	//CONSULTA SQL CURSA
	public final static String selectAllCursa= "SELECT CURSA, ANHO, ID_MODULO, DNI FROM Cursa";
	public final static String insertCursa= "INSERT INTO CURSA (ANHO, ID_MODULO, DNI, NOTA) VALUES (?,?,?,?)";
	public final static String updateCursa= "UPDATE CURSA SET ANHO = ?, NOTA=? WHERE DNI = ? AND ID_MODULO=?";
	public final static String deleteCursa= "DELETE FROM CURSA WHERE DNI = ? AND ID_MODULO=?";

//	//CONSULTA SQL ALUMNO
	public final static String selectAllAlumno= "SELECT DNI, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO, TELEFONO, FECHANACIMIENTO FROM ALUMNOS";
	public final static String insertAlumno= "INSERT INTO ALUMNO (DNI, NOMBRE, PRIMERAPELLIDO, SEGUNDOAPELLIDO, TELEFONO, FECHANACIMIENTO) VALUES (?,?,?,?,?,?)";
	public final static String updateAlumno=  "UPDATE ALUMNO SET NOMBRE = ?, PRIMERAPELLIDO = ?, SEGUNDOAPELLIDO = ?, TELEFONO = ?, FECHANACIMIENTO = ? WHERE DNI = ?";
	public final static String deleteAlumno= "DELETE FROM ALUMNO WHERE DNI = ?";

	
 }