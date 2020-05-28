package pfc.entidad;

import java.util.Set;

public class RegistroCliente {

	private String login;
	private String nombre;
	private String contrasenha;

	public RegistroCliente() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	@Override
	public String toString() {
		return "RegistroCliente [login=" + login + ", nombre=" + nombre + ", contrasenha=" + contrasenha + "]";
	}

}
