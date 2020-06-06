package pfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pfc.entidad.Menu;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;

/**
 * Servlet implementation class NewMenu
 */
@WebServlet("/addmenu")
public class NewMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMenu() {
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
	
		System.out.println("paso por aqui");
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String login = request.getParameter("login");
		String id = request.getParameter("id");
		
		
		Menu menu =new Menu();
		RegistroRestaurante res= new RegistroRestaurante();
		res.setLogin(login);
		menu.setDescripcion(descripcion);
		menu.setTitulo(titulo);
		menu.setRestaurante(res);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			if(id.equals("-1")) {
				AccesoDatos.addMenu(menu);
			}else {
				menu.setId(Integer.valueOf(id));
				AccesoDatos.modifyMenu(menu);

			}
		} catch (Exception e) {
			out.print("false");
			out.flush();
		}
		out.print("true");
		out.flush();

		
	}

}
