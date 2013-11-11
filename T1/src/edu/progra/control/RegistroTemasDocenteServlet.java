package edu.progra.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.progra.bean.ContenidoCurso;
import edu.progra1.factory.DAOFactory;
import edu.progra1.factory.Entity;

/**
 * Servlet implementation class RegistroTemasDocenteServlet
 */
@WebServlet("/RegistroTemaDocente")
public class RegistroTemasDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroTemasDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Usuario/docente/registroTemas.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		try{
		String nombre= request.getParameter("txt_nombre");
		
		String link=request.getParameter("txt_link");
		
		String semana=request.getParameter("txt_semana");
		
		String unidad=request.getParameter("txt_unidad");
		
		ContenidoCurso obj= new ContenidoCurso();
		obj.setNombreTema(nombre);
		obj.setLink(link);
		obj.setSemana(semana);
		obj.setUnidad(unidad);
		
		Entity<ContenidoCurso> biblioDAO=
				DAOFactory.getFactory(DAOFactory.MYSQL).getTemasDAO();
		
		boolean flag= biblioDAO.agregar(obj);
		
		if(flag){
			request.setAttribute("mensaje", "DATOS AGREGADOS");
		}else{
			request.setAttribute("mensaje", "¡ERROR!");
		}
		
		request.getRequestDispatcher("/Administrador/mensaje.jsp").forward(request,	response);
		}catch(Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	}
	}

