DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.BibliografiaCurso"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Modulo de Administracion</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/theme1.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/admin/style.css" />
<!--[if IE]>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/ie.css" />
<![endif]-->
</head>
<body>
<div id="container">
	<div id="header">
		<%@ include file="bienvenido.jsp" %>
    </div>
    <div id="top-panel">
		<div id="panel"></div>
	</div>
	<div id="wrapper">
		<div id="content" style="height: 210px;">
             <!-- contenido especifico por pagina -->
             <%
             BibliografiaCurso biblio = 
             				(BibliografiaCurso)request.getAttribute("biblio");
             %>
             <h3>Editar Libro</h3>
             <form action="<%=request.getContextPath() %>/EditarDetalleCursoServlet" method="post">
             <input type="hidden" value="editar" name="funcion" />
             <input type="hidden" value="<%=biblio.getIdLibroCurso() %>" name="txt_id" />  
             Nombre: <input value="<%=biblio.getNombreLibro() %>" type="text" name="txt_nombre" />
             <br /><br />
             <p> </p>
              Descripcion: <input value="<%=biblio.getDescripcion() %>" type="text" name="txt_descripcion" />
             <br /><br />
             <p> </p>
              Link: <input value="<%=biblio.getLink() %>" type="text" name="txt_link" />
             <br /><br />
             
             <input type="submit" value="Guardar" /> 
             </form>  
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
