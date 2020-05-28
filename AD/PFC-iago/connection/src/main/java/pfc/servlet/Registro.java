package pfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pfc.entidad.RegistroCliente;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;

/**
 * Servlet implementation class Registro
 */
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

		if (tipo.equals("Restaurante")) {
			RegistroRestaurante rgRestaurante = new RegistroRestaurante();
			rgRestaurante.setLogin(login);
			rgRestaurante.setContrasenha(contra);
			rgRestaurante.setNombreHosteleria(nombre);
			rgRestaurante.setUbicacion(ubicacion);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			RegistroCliente rg = new RegistroCliente();
			rg.setLogin(login);
			logged = AccesoDatos.existClient(rg);
			if (logged == true) {
				out.print("false");

			} else {

				// que pasa si el restaurante ya existe
				AccesoDatos.addLoginRestaurante(rgRestaurante);
				out.print("true");

			}

			out.flush();
		} else if (tipo.equals("Comun")) {
			RegistroCliente rgCliente = new RegistroCliente();
			rgCliente.setLogin(login);
			rgCliente.setNombre(nombre);
			rgCliente.setContrasenha(contra);
			RegistroRestaurante rgRestaurante = new RegistroRestaurante();
			rgRestaurante.setLogin(login);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			logged2 = AccesoDatos.existRestaurant(rgRestaurante);
			if (logged2 == true) {
				out.print("false");

			} else {

				// que pasa si el CLIENTE ya existe
				AccesoDatos.addLoginCliente(rgCliente);
				out.print("true");

			}

			out.flush();

		}

	}
}
