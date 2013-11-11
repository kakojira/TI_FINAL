<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.DetalleCurso"%>
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
             	Vector<DetalleCurso> detalle =
             			(Vector)request.getAttribute("detalle");
             %>
             <table>
             	<thead>
             		<tr>
             			<td>Nombre</td>
             			<td>Codigo</td>
             			<td>PreRequisito</td>
             			<td>Creditos</td>
             			<td>Condicion</td>
             			<td>Opciones</td>
             		</tr>
             	</thead>
             	<tbody>
             		<% for(int i=0; i<detalle.size(); i++){ %>
             		<tr>
             			<td><%=detalle.get(i).getNombre() %></td>
             			<td><%=detalle.get(i).getCodigo() %></td>
             			<td><%=detalle.get(i).getPreRequisito() %></td>
             			<td><%=detalle.get(i).getCredito() %></td>
             			<td><%=detalle.get(i).getCondicion() %></td>
             			<td>
             			<a href="<%=request.getContextPath() %>/InformacionServlet?funcion=editar&codigo=<%=detalle.get(i).getIdDetallecurso() %>">Editar</a>
             			<a href="<%=request.getContextPath() %>/InformacionServlet?funcion=eliminar&codigo=<%=detalle.get(i).getIdDetallecurso() %>">Eliminar</a>
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