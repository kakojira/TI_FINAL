package edu.progra.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.progra.bean.DetalleCurso;
import edu.progra1.factory.DAOFactory;

/**
 * Servlet implementation class AyudaServlet
 */
@WebServlet("/AyudaServlet")
public class AyudaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AyudaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int cod=Integer.parseInt(request.getParameter("cod"));
		if(cod==1){
			 
					request.getRequestDispatcher("/Usuario/ayuda.jsp").
								forward(request, response);
		 }else if(cod==2){
			 
					request.getRequestDispatcher("/Usuario/docente/ayudaDocente.jsp").
								forward(request, response);
		 }
	}

	

}
