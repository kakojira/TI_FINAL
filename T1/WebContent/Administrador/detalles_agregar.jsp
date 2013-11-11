<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
            <h3>CURSO</h3>
            <p>Agregar nuevos Detalles</p>
             <form action="<%=request.getContextPath() %>/AgregarDetalleServlet" method="post">
             <input type="hidden" value="agregar" name="funcion" /> 
             Nombre: <input type="text" name="nom"/><br></br>
             <p> </p>
             Credito: <input type="text" name="credito"/><br></br>
             <p> </p>
             Requisito: <input type="text" name="requisito"/><br></br>
             <p> </p>
             Codigo: <input type="text" name="codigo"/><br></br>
             <p> </p>
             Condicion: <input type="text" name="condicion"/><br></br>
             <input type="submit" value="Guardar"/>
             </form>
		</div>
		<div id="sidebar"><%@ include file="sidebar.jsp" %></div>
	</div>
	</div>
</body>
</html>