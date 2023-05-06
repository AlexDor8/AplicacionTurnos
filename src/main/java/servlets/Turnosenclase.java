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
 * Servlet implementation class Turnos
 */
@WebServlet(name="turnosenclase", urlPatterns="/turnosenclase.do")
public class Turnosenclase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Service service;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Turnosenclase() {
    	service = new Service();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String allQueries = request.getParameter("allQueries");
		try {
			request.setAttribute("consultas",service.todasConasultas());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/jsp/turnos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("consultas",service.todasConasultas());
			//request.setAttribute("consultas",service.todasConasultas());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//doGet(request, response);
		getServletContext().getRequestDispatcher("/jsp/turnos.jsp").forward(request, response);
	}

}
