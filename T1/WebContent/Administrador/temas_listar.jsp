<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.ContenidoCurso"%>
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
             	Vector<ContenidoCurso> contenido =
             			(Vector)request.getAttribute("contenido");
             %>
             <table>
             	<thead>
             		<tr>
             			<td>Nombre</td>
             			<td>Semana</td>
             			<td>Unidad</td>
             			<td>Link</td>
             			<td>Opciones</td>
             		</tr>
             	</thead>
             	<tbody>
             		<% for(int i=0; i<contenido.size(); i++){ %>
             		<tr>
             			<td><%=contenido.get(i).getNombreTema() %></td>
             			<td><%=contenido.get(i).getSemana() %></td>
             			<td><%=contenido.get(i).getUnidad() %></td>
             			<td><%=contenido.get(i).getLink() %></td>
             			
             			<td>
             			<a href="<%=request.getContextPath() %>/ContenidoServlet?funcion=editar&codigo=<%=contenido.get(i).getIdContenidoCurso() %>">Editar</a>
             			<a href="<%=request.getContextPath() %>/ContenidoServlet?funcion=eliminar&codigo=<%=contenido.get(i).getIdContenidoCurso() %>">Eliminar</a>
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