<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.Usuario"%>
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
             	Vector<Usuario> user =
             			(Vector)request.getAttribute("user");
             %>
             <table>
             	<thead>
             		<tr>
             			<td>Codigo</td>
             			<td>Password</td>
             			<td>Opciones</td>
             		</tr>
             	</thead>
             	<tbody>
             		<% for(int i=0; i<user.size(); i++){ %>
             		<tr>
             			<td><%=user.get(i).getCodigo() %></td>
             			<td><%=user.get(i).getPassword() %></td>
             			
             			
             			<td>
             			<a href="<%=request.getContextPath() %>/UsuarioServlet?funcion=editar&codigo=<%=user.get(i).getIdUsuario() %>">Editar</a>
             			<a href="<%=request.getContextPath() %>/UsuarioServlet?funcion=eliminar&codigo=<%=user.get(i).getIdUsuario() %>">Eliminar</a>
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