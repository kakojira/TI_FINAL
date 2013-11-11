package edu.progra1.factory;

import edu.progra.bean.*;
import edu.progra.factory.mysql.*;
import edu.progra.factory.mysql.MySQLLoginLogoutDAO;


public final class MySQLDAOFactory extends DAOFactory {
	@Override
	public Entity<DetalleCurso> getCursoDAO() {
		// TODO Auto-generated method stub
		return new MySQLInformacionDAO();
	}
	
	public Entity<ContenidoCurso> getTemasDAO() {
		// TODO Auto-generated method stub
		return new MySQLContenidoDAO();
	}
	
	@Override
	public Entity<Usuario> getLoginUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySQLLoginLogoutDAO();
	}
	
	public Entity<BibliografiaCurso> getBibliografiaDAO() {
		// TODO Auto-generated method stub
		return new MySQLBibliografiaDAO();
	}
	
	public Entity<Administrador> getLoginAdministradorDAO() {
		// TODO Auto-generated method stub
		return new MySQLLoginAdministradorDAO();
	}

}
