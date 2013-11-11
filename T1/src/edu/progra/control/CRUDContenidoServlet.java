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
 * Servlet implementation class CRUDContenidoServlet
 */
@WebServlet("/CRUDContenidoServlet")
public class CRUDContenidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDContenidoServlet() {
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
			 response.sendRedirect("Administrador/temas_agregar.jsp");
		 }else if(dato.equals("listar")){
			 try {
				 Entity<ContenidoCurso> biblioDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getTemasDAO();
					
					Vector<ContenidoCurso> biblio = biblioDAO.listar();
					
					request.setAttribute("contenido", biblio);
					
					request.getRequestDispatcher("/Administrador/temas_listar.jsp")
													.forward(request, response);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}

		 }else if(dato.equals("eliminar")){
			 try {
					String codigo = request.getParameter("codigo");
					 Entity<ContenidoCurso> biblioDAO=
								DAOFactory.getFactory(DAOFactory.MYSQL).getTemasDAO();
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
					 Entity<ContenidoCurso> biblioDAO=
								DAOFactory.getFactory(DAOFactory.MYSQL).getTemasDAO();
					ContenidoCurso bean = 
							biblioDAO.preactualizar(Integer.parseInt(codigo));
					
					request.setAttribute("contenido", bean);
					request.getRequestDispatcher("/Administrador/temas_editar.jsp")
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
				
				String semana=request.getParameter("semana");
				
				String unidad=request.getParameter("unidad");
				String link=request.getParameter("link");
				
				ContenidoCurso obj= new ContenidoCurso();
				obj.setNombreTema(nombre);
				obj.setSemana(semana);
				obj.setUnidad(unidad);
				obj.setLink(link);
				
				
				
				Entity<ContenidoCurso> biblioDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getTemasDAO();
				
				boolean flag= biblioDAO.agregar(obj);
				
				if(flag){
					request.setAttribute("mensaje", "DATOS AGREGADOS");
				}else{
					request.setAttribute("mensaje", "¡ERROR!");
				}
				
				request.getRequestDispatcher("/Administrador/mensaje.jsp").forward(request,	response);
			
				
			}else if(dato.equals("editar")){
				String nombre= request.getParameter("txt_nombre");
				
				String semana=request.getParameter("txt_semana");
				
				String unidad=request.getParameter("txt_unidad");
				String link=request.getParameter("txt_link");
				String id = request.getParameter("txt_id");
				
				
				
				ContenidoCurso bean = new ContenidoCurso();
				bean.setNombreTema(nombre);
				bean.setSemana(semana);
				bean.setUnidad(unidad);
				bean.setLink(link);
				bean.setIdContenidoCurso(Integer.parseInt(id));
				
				
				Entity<ContenidoCurso> biblioDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getTemasDAO();
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
