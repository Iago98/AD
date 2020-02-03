package modelo.esica;

public class MiSQL {

	//CONSULTAS SQL MODULO
	public final static String insertModulo= "INSERT INTO modulo (id, nombre, curso, horas, id_ciclo) VALUES (SEQ_MODULO.NEXTVALUE,?,?,?,?)";
	public final static String updateModulo= "UPDATE modulo SET nombre=?,curso=?,horas=?,id_ciclo=? WHERE id =?";
	public final static String selectAllModulo= "SELECT id, nombre, curso, horas, id_ciclo FROM modulo";
	public final static String deleteModulo= "DELETE FROM modulo WHERE id = ? ";
	
	//CONSULTA SQL CICLO
	public final static String selectAllCiclos= "SELECT id, nombre, nivel, curso FROM ciclo";
	
	
	
 }
