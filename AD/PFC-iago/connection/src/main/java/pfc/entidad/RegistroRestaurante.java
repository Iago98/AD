package pfc.entidad;

import java.io.Serializable;
import java.util.Set;

public class RegistroRestaurante implements Serializable{

	private String login;
	private String nombreHosteleria;
	private String ubicacion;
	private String contrasenha;
	private Set<Menu> menus;

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public RegistroRestaurante() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombreHosteleria() {
		return nombreHosteleria;
	}

	public void setNombreHosteleria(String nombreHosteleria) {
		this.nombreHosteleria = nombreHosteleria;
	}


	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	@Override
	public String toString() {
		return "RegistroRestaurante [login=" + login + ", nombreHosteleria=" + nombreHosteleria + ", ubicacion="
				+ ubicacion + ", contrasenha=" + contrasenha + ", menus=" + menus + "]";
	}

}
