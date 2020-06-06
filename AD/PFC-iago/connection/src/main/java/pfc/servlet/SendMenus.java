package pfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pfc.entidad.Menu;
import pfc.entidad.Menu2;
import pfc.entidad.RegistroRestaurante;
import pfc.modelo.AccesoDatos;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Servlet implementation class SendMenus
 */
@WebServlet("/requestmenu")

public class SendMenus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMenus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pasando menus");
		String login = request.getParameter("login");
		String contra = request.getParameter("contra");
		RegistroRestaurante res= new RegistroRestaurante();
		res.setLogin(login);
		res.setContrasenha(contra);
		List<Menu2> menus= AccesoDatos.recuperarMenus(res);
		System.out.println(menus.size());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	        String json = mapper.writeValueAsString(menus);
	        System.out.println(json);
	        out.print(json);
		out.flush();	

	}

}
