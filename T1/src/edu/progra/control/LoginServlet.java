package edu.progra.control;

import java.io.IOException;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginLogoutServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario objusuario = new Usuario();
		objusuario.setCodigo(request.getParameter("txt_usuario"));
		objusuario.setPassword(request.getParameter("txt_contraseña"));
		
		Usuario usuariobd = null;
		Entity<Usuario> usuarioDAO=
			DAOFactory.getFactory(DAOFactory.MYSQL).getLoginUsuarioDAO();
		usuariobd=usuarioDAO.findByPk(objusuario.getCodigo());
		
		String pagina="Usuario/mensaje.jsp";
		String mensaje="";
		if(usuariobd!=null){
			if(usuariobd.getPassword().equals(objusuario.getPassword())){
				HttpSession session= request.getSession(true);
				session.setAttribute("usuario", usuariobd);
				if(Integer.parseInt(usuariobd.getCodigo())<10000||Integer.parseInt(usuariobd.getCodigo())>99999){
					pagina= "Usuario/InformacionDocente.jsp";
				}
				pagina="Usuario/informacion.jsp";
			}else{
				mensaje ="Password incorrecto";
			}
		}else{
			mensaje ="No existe usuario";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(pagina).
			forward(request, response);
	}

}
