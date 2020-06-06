package pfc.entidad;

public class MiClasePersonalizada  implements Comparable<MiClasePersonalizada>{
	
	private int id;
	private String login;
	private String nombreHosteleria;
	private double distancia;

	public MiClasePersonalizada() {
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double latitud) {
		this.distancia = latitud;
	}

	@Override
	public String toString() {
		return "MiClasePersonalizada [login=" + login + ", nombreHosteleria=" + nombreHosteleria 
				+ ", distancia=" + distancia + "]";
	}

	public int compareTo(MiClasePersonalizada e) {
		if(e.getDistancia()>distancia){
            return -1;
        }else if(e.getDistancia()>distancia){
            return 0;
        }else{
            return 1;
        }
	}



}
