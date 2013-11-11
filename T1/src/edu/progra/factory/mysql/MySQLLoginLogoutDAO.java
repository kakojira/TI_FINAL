package edu.progra.factory.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Vector;

import edu.progra.bean.Usuario;
import edu.progra1.factory.Entity;
import edu.progra.util.DBConection;

public class MySQLLoginLogoutDAO implements Entity<Usuario> {
	


	@Override
	public Usuario  mostrar() {
		
		return null;
	}
	
	@Override
	public Usuario findByPk(String id) {
		// TODO Auto-generated method stub
		Usuario usuariobd = null;
		Connection con=null;
		try{
			con=DBConection.getConnection();
			String sql="SELECT * FROM t_usuario WHERE cuenta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				usuariobd = new Usuario();
				usuariobd.setIdUsuario(rs.getInt("idusuario"));
				usuariobd.setCodigo(rs.getString("codigo"));
				usuariobd.setPassword(rs.getString("clave"));
				usuariobd.setIdAdministrador(rs.getInt("correo"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
			DBConection.closeConnection(con);
		}
		return usuariobd;
		
	}
	
	public String validar(String user, String pass) throws Exception {
		
		return null;
	}
	
	
	
	@Override
	public boolean agregar(Usuario objad) throws Exception{
		// TODO Auto-generated method stub
	return true;
		
	}
	
	public boolean actualizar(Usuario objad) throws Exception{
		// TODO Auto-generated method stub
	return true;
		
	}
	
	public boolean eliminar(int id) throws Exception{
		// TODO Auto-generated method stub
	return true;
		
	}
	
	public Usuario preactualizar(int id) throws Exception{
		return null;
	}
	
	public Vector<Usuario> listar()throws Exception{
		return null;
	}
	


}
