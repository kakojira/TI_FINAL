<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.BibliografiaCurso"%>
<%@page import="java.util.Vector"%>
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
             	Vector<BibliografiaCurso> biblio =
             			(Vector)request.getAttribute("biblio");
             %>
             <table>
             	<thead>
             		<tr>
             			<td>Nombre</td>
             			<td>Descripcion</td>
             			<td>Link</td>
             			<td>Opciones</td>
             		</tr>
             	</thead>
             	<tbody>
             		<% for(int i=0; i<biblio.size(); i++){ %>
             		<tr>
             			<td><%=biblio.get(i).getNombreLibro() %></td>
             			<td><%=biblio.get(i).getDescripcion() %></td>
             			<td><%=biblio.get(i).getLink() %></td>
             			
             			<td>
             			<a href="<%=request.getContextPath() %>/BibliografiaServlet?funcion=editar&codigo=<%=biblio.get(i).getIdLibroCurso() %>">Editar</a>
             			<a href="<%=request.getContextPath() %>/BibliografiaServlet?funcion=eliminar&codigo=<%=biblio.get(i).getIdLibroCurso() %>">Eliminar</a>
             			</td>
             		</tr>
             		<% } %>
             	</tbody>
             </table>  
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>