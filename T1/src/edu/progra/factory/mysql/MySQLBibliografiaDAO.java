package edu.progra.factory.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import java.util.Vector;



import edu.progra.bean.BibliografiaCurso;
import edu.progra1.factory.Entity;
import edu.progra.util.DBConection;

public class MySQLBibliografiaDAO implements Entity<BibliografiaCurso> {
	
	@Override
	public String validar(String usu, String clave) throws Exception{
		return null;
	}
	
	@Override
	public BibliografiaCurso mostrar() {
		BibliografiaCurso bibliografiaInfo=new BibliografiaCurso();
		Connection con=null;
		try{
			con=DBConection.
					getConnection();
			String sql="SELECT * FROM t_libro_curso";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			BibliografiaCurso biblio;
			while(rs.next()){
				biblio = new BibliografiaCurso();

				biblio.setIdLibroCurso(rs.getInt("idLibroCurso"));
				biblio.setNombreLibro(rs.getString("nombreLibro"));
				biblio.setDescripcion(rs.getString("descripcion"));
				biblio.setLink(rs.getString("link"));
				biblio.setIdAdministrador(rs.getInt("idAdministrador"));
				
				bibliografiaInfo=biblio;
				
			}
		}catch(Exception ex){
			DBConection.closeConnection(con);
		}
		return 	bibliografiaInfo;
	}
	@Override
	public BibliografiaCurso findByPk(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean agregar(BibliografiaCurso obj) throws Exception {
		// TODO Auto-generated method stub
		boolean flag= false;
		
		try {
			Connection con= DBConection.
					getConnection();
			Statement stmt= con.createStatement();
			int filas=
					stmt.executeUpdate("insert into " +
							"t_libro_curso (nombre,link,descripcion) " +
							"values ('" + obj.getNombreLibro()+ "','" + obj.getLink()+ "','" + obj.getDescripcion()+ "')");
			if(filas==1){
				flag= true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public boolean actualizar(BibliografiaCurso obj) throws Exception {
		boolean flag = false;
		int rows=-1;
		try {
			Connection con = DBConection.
					getConnection();
			String sql="UPDATE t_libro_curso " +
					"SET nombrelibro=?,link=?,descripcion=?," +
					"WHERE id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, obj.getNombreLibro());
			ps.setString(2, obj.getLink());
			ps.setString(3, obj.getDescripcion());
			ps.setInt(4, obj.getIdLibroCurso());
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
					"t_libro_curso where idlibrocurso=" + id);
			if(filas == 1){
				flag = true;
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public Vector<BibliografiaCurso> listar() throws Exception {
		Vector<BibliografiaCurso> biblio = null;
		try {
			Connection con =DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idlibrocurso, nombrelibro, link, descripcion from t_libro_curso");
			
			biblio = new Vector<BibliografiaCurso>();
			BibliografiaCurso unbean = null;
			while(rs.next()){
				unbean = new BibliografiaCurso();
				unbean.setIdLibroCurso(rs.getInt("idlibrocurso"));
				unbean.setNombreLibro(rs.getString("nombrelibro"));
				unbean.setNombreLibro(rs.getString("link"));
				unbean.setNombreLibro(rs.getString("descripcion"));
				biblio.add(unbean);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return biblio;
	}

	@Override
	public BibliografiaCurso preactualizar(int id) throws Exception {
		BibliografiaCurso color = null;
		try {
			Connection con = DBConection.
					getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select idlibrocurso, nombrelibro, link, descripcion " +
					"from t_libro_curso where idlibrocurso=" + id);
			if(rs.next()){
				color = new BibliografiaCurso ();
				color.setIdLibroCurso( rs.getInt("idlibrocurso") );
				color.setNombreLibro( rs.getString("nombrelibro") );
				color.setLink( rs.getString("link") );
				color.setDescripcion( rs.getString("descripcion") );
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return color;
	}


}
