package edu.progra1.factory;

import java.util.Vector;





public interface Entity<T>{
	
	
	T mostrar();
	
	T findByPk(String id);
	
	String validar(String usu, String clave) throws Exception;
	
	boolean agregar (T obj) throws Exception;

	boolean actualizar (T obj) throws Exception;
	
	boolean eliminar (int id) throws Exception;
	
	T preactualizar(int id) throws Exception;

	Vector<T> listar() throws Exception;


}
