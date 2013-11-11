package edu.progra.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import edu.progra.bean.Usuario;
import edu.progra1.factory.DAOFactory;
import edu.progra1.factory.Entity;

/**
 * Servlet implementation class LoginLogoutServlet
 */
@WebServlet("/UsuarioServlet")
public class CRUDUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String dato=request.getParameter("funcion");
		 
		 if(dato.equals("agregar")){
			 response.sendRedirect("Administrador/usuario_agregar.jsp");
		 }else if(dato.equals("listar")){
			 try {
				 Entity<Usuario> biblioDAO=
							DAOFactory.getFactory(DAOFactory.MYSQL).getLoginUsuarioDAO();
					
					Vector<Usuario> user = biblioDAO.listar();
					
					request.setAttribute("user", user);
					
					request.getRequestDispatcher("/Administrador/usuario_listar.jsp")
													.forward(request, response);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}

		 }else if(dato.equals("eliminar")){
			 try {
					String codigo = request.getParameter("codigo");
					 Entity<Usuario> biblioDAO=
								DAOFactory.getFactory(DAOFactory.MYSQL).getLoginUsuarioDAO();
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
					 Entity<Usuario> biblioDAO=
								DAOFactory.getFactory(DAOFactory.MYSQL).getLoginUsuarioDAO();
					Usuario bean = 
							biblioDAO.preactualizar(Integer.parseInt(codigo));
					
					request.setAttribute("user", bean);
					request.getRequestDispatcher("/Administrador/usuario_editar.jsp")
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
				
				String codigo=request.getParameter("cod");
				
				String password=request.getParameter("pass");
				
				
				Usuario obj= new Usuario();
				obj.setCodigo(codigo);
				obj.setPassword(password);
				
				
			
				Entity<Usuario> biblioDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getLoginUsuarioDAO();
				
				boolean flag= biblioDAO.agregar(obj);
				
				if(flag){
					request.setAttribute("mensaje", "DATOS AGREGADOS");
				}else{
					request.setAttribute("mensaje", "¡ERROR!");
				}
				
				request.getRequestDispatcher("/Administrador/mensaje.jsp").forward(request,	response);
			
				
			}else if(dato.equals("editar")){
				
				
				String codigo=request.getParameter("txt_codigo");
				
				String password=request.getParameter("txt_password");
				
				String id = request.getParameter("txt_id");
				
				
				
				Usuario bean = new Usuario();
				bean.setCodigo(codigo);
				bean.setPassword(password);
				bean.setIdUsuario(Integer.parseInt(id));
				
				
				Entity<Usuario> biblioDAO=
						DAOFactory.getFactory(DAOFactory.MYSQL).getLoginUsuarioDAO();
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
