package edu.progra1.factory;

import edu.progra.bean.*;


public abstract class  DAOFactory {

public static final int MYSQL=1;
	
	public static DAOFactory getFactory(int opcion){
		switch (opcion) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			break;
		}
		return null;
	}
	
	public abstract Entity<DetalleCurso> getCursoDAO();
	public abstract Entity<ContenidoCurso> getTemasDAO();
	public abstract Entity<Usuario> getLoginUsuarioDAO();
	public abstract Entity<BibliografiaCurso> getBibliografiaDAO();
	public abstract Entity<Administrador> getLoginAdministradorDAO();
	
	
	
	
	
}
