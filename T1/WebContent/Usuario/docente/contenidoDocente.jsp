<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
  });
  </script>
  <style>
  .ui-tabs-vertical { width: 55em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
  </style>
<style type="text/css">
<!--
.style2 {font-family: "Comic Sans MS"}
.style3 {
	font-size: 36px;
	font-family: "Comic Sans MS";
	color: #990000;
}
.style4 {color: #000000}
-->
</style>
</head>
<body>
<%@ page import="edu.progra.bean.ContenidoCurso" %>

<%
	ContenidoCurso curso=(ContenidoCurso)request.getAttribute("tema");
%>
<form name="form1" method="post" action="">
  <table width="861" height="596" border="0" bgcolor="#000000">
    <tr>
      <td height="96" colspan="2" bgcolor="#FFFFFF"><div align="justify">
        <table width="583" height="92" border="0" bgcolor="#FFFFFF">
          <tr>
            <td width="385"><div align="center"><span class="style3">E - Learning USMP</span> </div></td>
            <td width="188"><img src="images/libro principal.png" width="155" height="115"></td>
          </tr>
        </table>
      </div></td>
      <td width="260" bgcolor="#FFFFFF"> <div align="center" class="style3 style4">Bienvenido Docente</div></td>
    </tr>
    <tr>
      <td width="222" bgcolor="#FFFFFF"><ul>
         <li class="style2"><a href="<%=request.getContextPath() %>/InformacionServlet?cod=2">Informacion de Curso</a></li>
        </ul>
        <ul class="style2">
          <li><a href="<%=request.getContextPath() %>/ContenidoServlet?cod=2">Contenido del Curso</a> </li>
        </ul>
        <ul>
          <li class="style2"><a href="<%=request.getContextPath() %>/BibliografiaServlet?cod=2">Bibliografia</a></li>
        </ul>
         <ul>
          <li class="style2"><a href="<%=request.getContextPath() %>/AyudaServlet?cod=2">Ayuda</a></li>
        </ul>
        <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
      <td  height="365" colspan="2" bgcolor="#FFFFFF"><div id="tabs">
  <ul>
    <li><a href="#tabs-1">Unidad 1</a></li>
    <li><a href="#tabs-2">Unidad 2</a></li>
    <li><a href="#tabs-3">Unidad 3</a></li>
    <li><a href="#tabs-4">Unidad 4</a></li>
  </ul>
  <div id="tabs-1">
    <h2>Unidad 1</h2>
    	<p> <a href="<%=request.getContextPath() %>/RegistroTemaDocente">Registrar tema</a></p>
		<p> > Semana 1: ................... </p>
		<p> </p>
		<p> > Semana 2: ................... </p>
		<p> </p>
		<p> > Semana 3: ................... </p>
		<p> </p>
		</div>
  <div id="tabs-2">
    <h2>Unidad 2</h2>
   <p> <a href="<%=request.getContextPath() %>/RegistroTemaDocente">Registrar tema</a></p>
<p> > Semana 4: ................... </p>
		<p> </p>
		<p> > Semana 5: ................... </p>
		<p> </p>
		<p> > Semana 6: ................... </p>
		<p> </p>  </div>
  <div id="tabs-3">
    <h2>Unidad 3</h2>
    <p> <a href="<%=request.getContextPath() %>/RegistroTemaDocente">Registrar tema</a></p>
    	<p> > Semana 7: ................... </p>
		<p> </p>
		<p> > Semana 8: ................... </p>
		<p> </p>
		<p> > Semana 9: ................... </p>
		<p> </p>
  </div>
  <div id="tabs-4">
  
    <h2>Unidad 4</h2>
   <p> <a href="<%=request.getContextPath() %>/RegistroTemaDocente">Registrar tema</a></p>
    	<p> > Semana 10: ................... </p>
		<p> </p>
		<p> > Semana 11: ................... </p>
		<p> </p>
		<p> > Semana 12: ................... </p>
		<p> </p>
  </div>
</div></td>
    </tr>
    <tr>
      <td height="112" colspan="3" bgcolor="#FFFFFF"><div align="center"><img src="images/logoo.png" width="408" height="90"></div></td>
    </tr>
  </table>
</form>
</body>
</html>