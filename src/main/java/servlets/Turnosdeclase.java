package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

/**
 * Servlet implementation class Turnosenclase
 */
@WebServlet(name="turnosdeclase", urlPatterns="/turnosdeclase.do")
public class Turnosdeclase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Service service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Turnosdeclase() {
    	service = new Service();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/turnodeclase.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String checkboxValue = request.getParameter("borrado");
		
		if (checkboxValue != null) {
			try {
				service.eliminarConsulta(nombre);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				service.insertarConsulta(nombre);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		getServletContext().getRequestDispatcher("/jsp/turnodeclase.jsp").forward(request, response);
	}

}
