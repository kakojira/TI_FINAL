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
 * Servlet implementation class CRUDDetalleCursoServlet
 */
@WebServlet("/CRUDInformacionServlet")
public class CRUDDetalleCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDDetalleCursoServlet() {
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
			 response.sendRedirect("Administrador/detalles_agregar.jsp");
		 }else if(dato.equals("listar")){
			 try {
				 Entity<DetalleCurso> detalleDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getCursoDAO();
					
					Vector<DetalleCurso> detalle = detalleDAO.listar();
					
					request.setAttribute("detalle", detalle);
					
					request.getRequestDispatcher("/Administrador/detalles_listar.jsp")
													.forward(request, response);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}

		 }else if(dato.equals("eliminar")){
			 try {
					String codigo = request.getParameter("codigo");
					Entity<DetalleCurso> detalleDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getCursoDAO();
					boolean flag = detalleDAO.eliminar(Integer.parseInt(codigo));
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
					Entity<DetalleCurso> detalleDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getCursoDAO();
					DetalleCurso bean = 
							detalleDAO.preactualizar(Integer.parseInt(codigo));
					
					request.setAttribute("detalle", bean);
					request.getRequestDispatcher("/Administrador/detalles_editar.jsp")
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
				Integer credito=Integer.parseInt(request.getParameter("credito"));
				String requisito=request.getParameter("requisito");
				Integer codigo=Integer.parseInt(request.getParameter("codigo"));
				String condicion=request.getParameter("condicion");
				
				DetalleCurso obj= new DetalleCurso();
				obj.setNombre(nombre);
				obj.setCredito(credito);
				obj.setPreRequisito(requisito);
				obj.setCodigo(codigo);
				obj.setCondicion(condicion);
				
				Entity<DetalleCurso> detalleDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getCursoDAO();
				
				boolean flag= detalleDAO.agregar(obj);
				
				if(flag){
					request.setAttribute("mensaje", "DATOS AGREGADOS");
				}else{
					request.setAttribute("mensaje", "¡ERROR!");
				}
				
				request.getRequestDispatcher("/Administrador/mensaje.jsp").forward(request,	response);
			
				
			}else if(dato.equals("editar")){
				String nombre = request.getParameter("txt_nombre");
				String id = request.getParameter("txt_id");
				String codigo=request.getParameter("txt_codigo");
				String prerequisito=request.getParameter("txt_prerequisito");
				String condicion=request.getParameter("txt_condicion");
				String credito=request.getParameter("txt_credito");
				
				
				
				DetalleCurso bean = new DetalleCurso();
				bean.setNombre(nombre);
				bean.setIdDetallecurso(Integer.parseInt(id));
				bean.setCodigo(Integer.parseInt(codigo));
				bean.setPreRequisito(prerequisito);
				bean.setCondicion(condicion);
				bean.setCredito(Integer.parseInt(credito));
				
				
				Entity<DetalleCurso> detalleDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getCursoDAO();
				boolean flag =
							detalleDAO.actualizar(bean);
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
