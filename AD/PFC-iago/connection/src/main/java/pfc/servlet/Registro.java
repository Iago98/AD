package pfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pfc.entidad.RegistroCliente;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/registro")

public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean logged;
		Boolean logged2;
		String str;
		String login = request.getParameter("login");
		String tipo = request.getParameter("tipo");
		String contra = request.getParameter("contra");
		String ubicacion = request.getParameter("ubicacion");
		String nombre = request.getParameter("nombre");

		System.out.println(login);
		System.out.println(contra);
		System.out.println(tipo);
		System.out.println(ubicacion);
		System.out.println(nombre);

		RegistroRestaurante rgRestaurante = new RegistroRestaurante();
		rgRestaurante.setLogin(login);
		RegistroCliente rgCliente = new RegistroCliente();
		rgCliente.setLogin(login);
		logged = AccesoDatos.existRestaurant(rgRestaurante);
		logged2 = AccesoDatos.existClient(rgCliente);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if (logged || logged2) {
			str = "false";
			System.out.println("existe comun: "+logged.toString()+"o restaurante: "+logged2.toString());
		} else {

			if (tipo.equals("Restaurante")) {
				rgRestaurante.setContrasenha(contra);
				rgRestaurante.setNombreHosteleria(nombre);
				rgRestaurante.setUbicacion(ubicacion);
				AccesoDatos.addLoginRestaurante(rgRestaurante);
				str = "true";
			} else {
				rgCliente.setNombre(nombre);
				rgCliente.setContrasenha(contra);
				AccesoDatos.addLoginCliente(rgCliente);
				str = "true";

			}

		}
		out.print(str);
		out.flush();

	}
}
