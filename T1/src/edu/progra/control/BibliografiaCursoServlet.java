package edu.progra.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.progra.bean.BibliografiaCurso;
import edu.progra1.factory.DAOFactory;
import edu.progra1.factory.Entity;

/**
 * Servlet implementation class BibliografiaServlet
 */
@WebServlet("/BibliografiaServlet")
public class BibliografiaCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliografiaCursoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod=Integer.parseInt(request.getParameter("cod"));
		
		if(cod==1){
			BibliografiaCurso bibliografia= new BibliografiaCurso();
			DAOFactory.getFactory(DAOFactory.MYSQL).
			getBibliografiaDAO().mostrar();
				request.setAttribute("bibliografia", bibliografia);
		
			request.getRequestDispatcher("Usuario/bibliografia.jsp").forward(request,response);
		}else{
			BibliografiaCurso bibliografia= new BibliografiaCurso();
			DAOFactory.getFactory(DAOFactory.MYSQL).
			getBibliografiaDAO().mostrar();
				request.setAttribute("bibliografia", bibliografia);
		
			request.getRequestDispatcher("Usuario/docente/bibliografiaDocente.jsp").forward(request,response);
		}
		
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
}
