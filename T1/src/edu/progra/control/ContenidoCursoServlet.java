package edu.progra.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import edu.progra.bean.ContenidoCurso;
import edu.progra1.factory.DAOFactory;
import edu.progra1.factory.Entity;

/**
 * Servlet implementation class ContenidoServlet
 */
@WebServlet("/ContenidoServlet")
public class ContenidoCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContenidoCursoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cod=Integer.parseInt(request.getParameter("cod"));
		
		if(cod==1){
			ContenidoCurso tema= new ContenidoCurso();
			DAOFactory.getFactory(DAOFactory.MYSQL).
			getCursoDAO().mostrar();
				request.setAttribute("tema", tema);
			request.getRequestDispatcher("Usuario/contenido.jsp").forward(request,response);
		}else{
			ContenidoCurso tema= new ContenidoCurso();
			DAOFactory.getFactory(DAOFactory.MYSQL).
			getCursoDAO().mostrar();
				request.setAttribute("tema", tema);
			request.getRequestDispatcher("Usuario/docente/contenidoDocente.jsp").forward(request,response);
		}
			
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
