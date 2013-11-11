package edu.progra.factory.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import java.util.Vector;


import edu.progra.bean.ContenidoCurso;
import edu.progra1.factory.Entity;
import edu.progra.util.DBConection;

public class MySQLContenidoDAO implements Entity<ContenidoCurso> {
	
	
	@Override
	public ContenidoCurso mostrar() {
		ContenidoCurso contenidoInfo=new ContenidoCurso();
		Connection con=null;
		try{
			con=DBConection.
					getConnection();
			String sql="SELECT * FROM t_tema_curso";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ContenidoCurso conte;
			while(rs.next()){
				conte = new ContenidoCurso();
				conte.setIdContenidoCurso(rs.getInt("idtemacurso"));
				conte.setNombreTema(rs.getString("nombreTema"));
				conte.setLink(rs.getString("link"));
				conte.setSemana(rs.getString("semana"));
				conte.setUnidad(rs.getString("unidad"));
				conte.setIdAdministrador(rs.getInt("idAdministrador"));
				contenidoInfo=conte;
				
			}
		}catch(Exception ex){
			DBConection.closeConnection(con);
		}
		return contenidoInfo;
	}
	@Override
	public ContenidoCurso findByPk(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String validar(String usu, String clave) throws Exception{
		return null;
	}
	
	
	@Override
	public boolean agregar(ContenidoCurso obj) throws Exception {
		// TODO Auto-generated method stub
		boolean flag= false;
		
		try {
			Connection con= DBConection.
					getConnection();
			Statement stmt= con.createStatement();
			int filas=
					stmt.executeUpdate("insert into " +
							"t_tema_curso (nombreTema,link,semana,unidad) " +
							"values ('" + obj.getNombreTema()+ "','" + obj.getLink()+ "','" + obj.getSemana()+ "','" + obj.getUnidad()+ "')");
			if(filas==1){
				flag= true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean actualizar(ContenidoCurso obj) throws Exception {
		boolean flag = false;
		int rows=-1;
		try {
			Connection con = DBConection.
					getConnection();
			String sql="UPDATE t_tema_curso " +
					"SET nombrelibro=?,link=?,semana=?,unidad=?" +
					"WHERE id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, obj.getNombreTema());
			ps.setString(2, obj.getLink());
			ps.setString(3, obj.getSemana());
			ps.setString(4, obj.getUnidad());
			ps.setInt(5, obj.getIdContenidoCurso());
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
					"t_tema_curso where idtemacurso=" + id);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Vector<ContenidoCurso> listar() throws Exception {
		Vector<ContenidoCurso> biblio = null;
		try {
			Connection con =DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idtemacurso, nombreTema, link, semana, unidad from t_tema_curso");
			
			biblio = new Vector<ContenidoCurso>();
			ContenidoCurso  unbean = null;
			while(rs.next()){
				unbean = new ContenidoCurso ();
				unbean.setIdContenidoCurso(rs.getInt("idtemacurso"));
				unbean.setNombreTema(rs.getString("nombreTema"));
				unbean.setLink(rs.getString("link"));
				unbean.setSemana(rs.getString("semana"));
				unbean.setUnidad(rs.getString("unidad"));
				biblio.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return biblio;
	}

	@Override
	public ContenidoCurso preactualizar(int id) throws Exception {
		ContenidoCurso  color = null;
		try {
			Connection con = DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idtemacurso, nombreTema, link, semana, unidad " +
					"from t_tema_curso where idtemacurso=" + id);
			if(rs.next()){
				color = new ContenidoCurso  ();
				color.setIdContenidoCurso( rs.getInt("idtemacurso") );
				color.setNombreTema( rs.getString("nombreTema") );
				color.setLink( rs.getString("link") );
				color.setSemana( rs.getString("semana") );
				color.setUnidad( rs.getString("unidad") );
				
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return color;
	}



}
