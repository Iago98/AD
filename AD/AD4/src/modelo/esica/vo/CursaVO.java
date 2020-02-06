package modelo.esica.vo;

public class CursaVO {

	private String anho;
	private int id_modulo;
	private String dni;
	private int nota;

	// Getter and Setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

		
	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public int getId_modulo() {
		return id_modulo;
	}

	public void setId_modulo(int id_modulo) {
		this.id_modulo = id_modulo;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}


}
