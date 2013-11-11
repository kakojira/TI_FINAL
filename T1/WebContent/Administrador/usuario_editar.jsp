

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.Usuario"%>
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
             Usuario user = 
             				(Usuario)request.getAttribute("user");
             %>
             <h3>Editar User</h3>
             <form action="<%=request.getContextPath() %>/EditarUsuarioServlet" method="post">
             <input type="hidden" value="editar" name="funcion" />
             <input type="hidden" value="<%=user.getIdUsuario() %>" name="txt_id" />  
             Codigo: <input value="<%=user.getCodigo() %>" type="text" name="txt_codigo" />
             <br /><br />
             <p> </p>
              Password: <input value="<%=user.getPassword() %>" type="text" name="txt_password" />
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