package pfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import pfc.entidad.RegistroCliente;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		//Devuelve si las creedenciales son correctas y el tipo de Login
		Boolean logged;
		Boolean logged2;

		String str;
		String login = request.getParameter("login");
		String contra = request.getParameter("contrasenha");
		System.out.println(login);
		System.out.println(contra);

		RegistroCliente rg = new RegistroCliente();
		rg.setLogin(login);
		rg.setContrasenha(contra);
		RegistroRestaurante rgRestaurante = new RegistroRestaurante();
		rgRestaurante.setLogin(login);
		rgRestaurante.setContrasenha(contra);
		logged = AccesoDatos.isLoginCliente(rg);
		logged2 = AccesoDatos.isLoginRestaurante(rgRestaurante);
		System.out.println(logged2.toString());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if (logged == true) {
			out.print("true-cliente");
		} else if (logged == false) {
			logged = AccesoDatos.isLoginRestaurante(rgRestaurante);
			if (logged2 == true) {
				out.print("true-restaurante");
			} else {
				out.print("false-null");
			}
		}
		out.flush();	
	}

}
