package edu.progra.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import edu.progra.bean.DetalleCurso;
import edu.progra1.factory.DAOFactory;
import edu.progra1.factory.Entity;

/**
 * Servlet implementation class InformacionServlet
 */
@WebServlet("/InformacionServlet")
public class DetalleCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleCursoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int cod=Integer.parseInt(request.getParameter("cod"));
		 
		 if(cod==1){
			 DetalleCurso curso= new DetalleCurso();
				DAOFactory.getFactory(DAOFactory.MYSQL).
				getCursoDAO().mostrar();
					request.setAttribute("curso", curso);
					request.getRequestDispatcher("/Usuario/informacion.jsp").
								forward(request, response);
		 }else if(cod==2){
			 DetalleCurso curso= new DetalleCurso();
				DAOFactory.getFactory(DAOFactory.MYSQL).
				getCursoDAO().mostrar();
					request.setAttribute("curso", curso);
					request.getRequestDispatcher("/Usuario/docente/informacionDocente.jsp").
								forward(request, response);
		 }
		 
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


}
