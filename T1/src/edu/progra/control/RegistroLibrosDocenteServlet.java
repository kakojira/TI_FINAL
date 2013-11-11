package edu.progra.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.progra.bean.BibliografiaCurso;
import edu.progra1.factory.DAOFactory;
import edu.progra1.factory.Entity;

/**
 * Servlet implementation class RegistroLibrosServlet
 */
@WebServlet("/RegistroLibrosDocente")
public class RegistroLibrosDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroLibrosDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Usuario/docente/registroLibros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		try{
		String nombre= request.getParameter("txt_nuevoLibro");
		
		String link=request.getParameter("txt_link");
		
		String descripcion=request.getParameter("txa_descripcion");
		
		BibliografiaCurso obj= new BibliografiaCurso();
		obj.setNombreLibro(nombre);
		obj.setLink(link);
		obj.setDescripcion(descripcion);
		
		Entity<BibliografiaCurso> biblioDAO=
				DAOFactory.getFactory(DAOFactory.MYSQL).getBibliografiaDAO();
		
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
