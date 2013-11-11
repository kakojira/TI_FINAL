package edu.progra.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import edu.progra.bean.Administrador;
import edu.progra1.factory.Entity;
import edu.progra1.factory.DAOFactory;

/**
 * Servlet implementation class AdministradorServlet
 */
@WebServlet("/AdministradorServlet")
public class AdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession sesiones = request.getSession();
			sesiones.removeAttribute("nombreadm");
			
			response.sendRedirect("Administrador/login.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String usuario= request.getParameter("txt_user");
			String clave= request.getParameter("txt_pass");
			
			Entity<Administrador> AdministradorDAO=
					DAOFactory.getFactory(DAOFactory.MYSQL).getLoginAdministradorDAO();
			
			String nombre= AdministradorDAO.validar(usuario, clave);
			
			if(nombre.equals("")){
				response.sendRedirect("Administrador/login.jsp");
			}else{
				HttpSession sesiones= request.getSession();
				sesiones.setAttribute("nombreadm", nombre);
				
				response.sendRedirect("Administrador/inicio.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}

}
