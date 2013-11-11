package edu.progra.factory.mysql;

import edu.progra.bean.Administrador;

import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.progra1.factory.Entity;
import edu.progra.util.DBConection;

public class MySQLLoginAdministradorDAO implements Entity<Administrador>{
	
	@Override
	public String validar(String user, String pass) throws Exception {
		String nombre= "";
		
		try {
			Connection con= DBConection.getConnection();
			Statement stmt= con.createStatement();
			ResultSet rs= 
					stmt.executeQuery("select nombre " +
					"from t_administrador " +
					"where usuario ='"+user+"' " +
					"and clave='"+pass+"'");
			
			if(rs.next()){
				nombre = rs.getString("nombre");
			}				
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
				
		return nombre;
	}
	
	@Override
	public Administrador  mostrar() {
		
		return null;
	}
	
	@Override
	public Administrador findByPk(String id) {
		// TODO Auto-generated method stub
	return null;
		
	}
	
	@Override
	public boolean agregar(Administrador objad) throws Exception{
		// TODO Auto-generated method stub
	return true;
		
	}
	
	public boolean actualizar(Administrador objad) throws Exception{
		// TODO Auto-generated method stub
	return true;
		
	}
	
	public boolean eliminar(int id) throws Exception{
		// TODO Auto-generated method stub
	return true;
		
	}
	
	public Administrador preactualizar(int id) throws Exception{
		return null;
	}
	
	public Vector<Administrador> listar()throws Exception{
		return null;
	}
	

}
