

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="edu.progra.bean.DetalleCurso"%>
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
             DetalleCurso detalle = 
             				(DetalleCurso)request.getAttribute("detalle");
             %>
             <h3>Editar Detalle Curso</h3>
             <form action="<%=request.getContextPath() %>/EditarDetalleCursoServlet" method="post">
             <input type="hidden" value="editar" name="funcion" />
             <input type="hidden" value="<%=detalle.getIdDetallecurso() %>" name="txt_id" />  
             Nombre: <input value="<%=detalle.getNombre() %>" type="text" name="txt_nombre" />
             <br /><br />
             <p> </p>
              Codigo: <input value="<%=detalle.getCodigo() %>" type="text" name="txt_codigo" />
             <br /><br />
             <p> </p>
              PreRequisito: <input value="<%=detalle.getPreRequisito() %>" type="text" name="txt_prerequisito" />
             <br /><br />
             <p> </p>
              Condicion: <input value="<%=detalle.getCondicion() %>" type="text" name="txt_condicion" />
             <br /><br />
             <p> </p>
              Creditos: <input value="<%=detalle.getCredito() %>" type="text" name="txt_credito" />
             <br /><br />
             <p> </p>
             <input type="submit" value="Guardar" /> 
             </form>  
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	<div id="footer"><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
