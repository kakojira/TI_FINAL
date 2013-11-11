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
 * Servlet implementation class CRUDBibliografiaServlet
 */
@WebServlet("/CRUDBibliografiaServlet")
public class CRUDBibliografiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDBibliografiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dato=request.getParameter("funcion");
		 
		 if(dato.equals("agregar")){
			 response.sendRedirect("Administrador/libros_agregar.jsp");
		 }else if(dato.equals("listar")){
			 try {
				 Entity<BibliografiaCurso> biblioDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getBibliografiaDAO();
					
					Vector<BibliografiaCurso> biblio = biblioDAO.listar();
					
					request.setAttribute("biblio", biblio);
					
					request.getRequestDispatcher("/Administrador/libros_listar.jsp")
													.forward(request, response);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}

		 }else if(dato.equals("eliminar")){
			 try {
					String codigo = request.getParameter("codigo");
					Entity<BibliografiaCurso> biblioDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getBibliografiaDAO();
					boolean flag = biblioDAO.eliminar(Integer.parseInt(codigo));
					if(flag){
						request.setAttribute("mensaje", "ELIMINADO");
					}else{
						request.setAttribute("mensaje", "¡ERROR!");
					}
					request.getRequestDispatcher("/Administrador/mensaje.jsp")
												.forward(request, response);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}
		 }else if(dato.equals("editar")){
			 try {
					String codigo = request.getParameter("codigo");
					Entity<BibliografiaCurso> biblioDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getBibliografiaDAO();
					BibliografiaCurso bean = 
							biblioDAO.preactualizar(Integer.parseInt(codigo));
					
					request.setAttribute("biblio", bean);
					request.getRequestDispatcher("/Administrador/libros_editar.jsp")
											.forward(request, response);
					
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}
		 }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String dato = request.getParameter("funcion");
		
		try {
			
			if(dato.equals("agregar")){
				String nombre= request.getParameter("nom");
				
				String link=request.getParameter("link");
				
				String descripcion=request.getParameter("descripcion");
				
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
			
				
			}else if(dato.equals("editar")){
				String nombre = request.getParameter("txt_nombre");
				String id = request.getParameter("txt_id");
				String descripcion=request.getParameter("txt_descripcion");
				String link=request.getParameter("txt_link");
				
				
				
				
				BibliografiaCurso bean = new BibliografiaCurso();
				bean.setNombreLibro(nombre);
				bean.setIdLibroCurso(Integer.parseInt(id));
				bean.setDescripcion(descripcion);
				bean.setLink(link);
				
				
				Entity<BibliografiaCurso> biblioDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getBibliografiaDAO();
				boolean flag =
							biblioDAO.actualizar(bean);
				if(flag){
					request.setAttribute("mensaje", "DATOS EDITADOS");
				}else{
					request.setAttribute("mensaje", "¡ERROR!");
				}
				request.getRequestDispatcher("/Administrador/mensaje.jsp")
											.forward(request, response);			
			}
			
						
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	}

}
