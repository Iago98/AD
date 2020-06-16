package pfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import pfc.entidad.Menu2;
import pfc.entidad.MiClasePersonalizada;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;

/**
 * Servlet implementation class RestaurantesCercanos
 */
@WebServlet("/comunMenu")
public class RestaurantesCercanos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantesCercanos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double distancia;
		List<RegistroRestaurante> listaPrincipal = new ArrayList<RegistroRestaurante>();
		List<MiClasePersonalizada> listaSegunda = new ArrayList<MiClasePersonalizada>();

		String tipo = request.getParameter("login");
		String contra = request.getParameter("contra");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		System.out.println("aqui login"+tipo);
		System.out.println("aqui contra"+contra);
		System.out.println("aqui latitude"+latitude);
		System.out.println("aqui longitude"+longitude);
		listaPrincipal=AccesoDatos.recuperarTodosRestaurante();
		double distanciaFinal;
		// ejemplo:                                     lat/lng: ( ||  42.2196095847658 || ,-8.732633516192436)
		
		for(int x=0;x<listaPrincipal.size();x++) {
			List<Menu2> result=AccesoDatos.recuperarMenus(listaPrincipal.get(x));
			if(result.isEmpty()) {
				listaPrincipal.remove(x);
			}
		}
		
		for (int i=0;i<listaPrincipal.size();i++) {
			String string =listaPrincipal.get(i).getUbicacion();
			
			String[] parts = string.split("\\(");
			String part2 = parts[1];
			System.out.println(part2);
			
			String[] part = part2.split(",");
			String latVar= part[0];
			System.out.println(latVar);

			String longMal= part[1];
			String longVar= longMal.substring(0, longMal.length() - 1);
			System.out.println(longVar);

		    
			distanciaFinal = distanciaCoord(Double.parseDouble(latitude),Double.parseDouble(longitude),Double.parseDouble(latVar),Double.parseDouble(longVar));
			MiClasePersonalizada miClass = new MiClasePersonalizada();
			miClass.setLogin(listaPrincipal.get(i).getLogin());
			miClass.setNombreHosteleria(listaPrincipal.get(i).getNombreHosteleria());
			miClass.setDistancia(distanciaFinal);
			miClass.setId(i);
			listaSegunda.add(miClass);
			
		}
		Collections.sort(listaSegunda);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	        String json = mapper.writeValueAsString(listaSegunda);
	        System.out.println(json);
	        out.print(json);
		out.flush();	
		
		for(int x=0;x<listaSegunda.size();x++) {
			System.out.println(listaSegunda.get(x).toString());
			
			
		}
		//Envia lista ordenada por kilometros.
	}
	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
        
        double radioTierra = 6371; //en kilómetros  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }


}
