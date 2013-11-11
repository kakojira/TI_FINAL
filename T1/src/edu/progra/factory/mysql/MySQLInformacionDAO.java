package edu.progra.factory.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import java.util.Vector;


import edu.progra.bean.DetalleCurso;
import edu.progra1.factory.Entity;
import edu.progra.util.DBConection;

public class MySQLInformacionDAO implements Entity<DetalleCurso> {
	


	@Override
	public DetalleCurso mostrar() {
		DetalleCurso cursoInfo=new DetalleCurso();
		Connection con=null;
		try{
			con=DBConection.
					getConnection();
			String sql="SELECT * FROM t_detalle_curso";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			DetalleCurso curso;
			while(rs.next()){
				curso = new DetalleCurso();
				curso.setIdDetallecurso(rs.getInt("idDetallecurso"));
				curso.setNombre(rs.getString("nombre"));
				curso.setCredito(rs.getInt("credito"));
				curso.setPreRequisito(rs.getString("prerequisito"));
				curso.setCondicion(rs.getString("condicion"));
				curso.setIdAdministrador(rs.getInt("idAdministrador"));
				cursoInfo=curso;
				
			}
		}catch(Exception ex){
			DBConection.closeConnection(con);
		}
		return cursoInfo;
	}
	
	@Override
	public DetalleCurso findByPk(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public String validar(String usu, String clave) throws Exception{
		return null;
	}
	
	
	@Override
	public boolean agregar(DetalleCurso obj) throws Exception {
		// TODO Auto-generated method stub
		boolean flag= false;
		
		try {
			Connection con= DBConection.
					getConnection();
			Statement stmt= con.createStatement();
			int filas=
					stmt.executeUpdate("insert into " +
							"t_detalle_curso (nombre,codigo,credito,prerequisito,condicion) " +
							"values ('" + obj.getNombre()+ "','" + obj.getCodigo()+ "','" + obj.getCredito()+ "','" + obj.getPreRequisito()+ "','" + obj.getCondicion()+ "')");
			if(filas==1){
				flag= true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean actualizar(DetalleCurso obj) throws Exception {
		boolean flag = false;
		int rows=-1;
		try {
			Connection con = DBConection.
					getConnection();
			String sql="UPDATE t_detalle_curso " +
					"SET nombre=?,codigo=?,credito=?,prerequisito=?,condicion=?" +
					"WHERE id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, obj.getNombre());
			ps.setInt(2, obj.getCodigo());
			ps.setInt(3, obj.getCredito());
			ps.setString(4, obj.getPreRequisito());
			ps.setString(5, obj.getCondicion());
			ps.setInt(6, obj.getIdDetallecurso());
			rows=ps.executeUpdate();
			if(rows == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean eliminar(int id) throws Exception {
		boolean flag = false;
		try {
			Connection con = DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			int filas = stmt.executeUpdate("delete from " +
					"t_detalle_curso where iddetallecurso=" + id);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Vector<DetalleCurso> listar() throws Exception {
		Vector<DetalleCurso> biblio = null;
		try {
			Connection con =DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select iddetallecurso, nombre, codigo, credito, prerequisito, condicion from t_detalle_curso");
			
			biblio = new Vector<DetalleCurso>();
			DetalleCurso  unbean = null;
			while(rs.next()){
				unbean = new DetalleCurso ();
				unbean.setIdDetallecurso(rs.getInt("iddetallecurso"));
				unbean.setNombre(rs.getString("nombre"));
				unbean.setCodigo(rs.getInt("codigo"));
				unbean.setCredito(rs.getInt("credito"));
				unbean.setPreRequisito(rs.getString("prerequisito"));
				unbean.setCondicion(rs.getString("condicion"));
				biblio.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return biblio;
	}

	@Override
	public DetalleCurso preactualizar(int id) throws Exception {
		DetalleCurso color = null;
		try {
			Connection con = DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select iddetallecurso, nombre, codigo, credito, prerequisito, condicion " +
					"from t_detalle_curso where iddetallecurso=" + id);
			if(rs.next()){
				color = new DetalleCurso  ();
				color.setIdDetallecurso( rs.getInt("iddetallecurso") );
				color.setNombre( rs.getString("nombre") );
				color.setCodigo( rs.getInt("codigo") );
				color.setCredito( rs.getInt("credito") );
				color.setPreRequisito( rs.getString("prerequisito") );
				color.setCondicion( rs.getString("condicion") );
				
				
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return color;
	}


	
}
