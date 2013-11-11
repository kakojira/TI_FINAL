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
  <script>
  $(function() {
    var tabs = $( "#tabs" ).tabs();
    tabs.find( ".ui-tabs-nav" ).sortable({
      axis: "x",
      stop: function() {
        tabs.tabs( "refresh" );
      }
    });
  });
  </script>
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
<%@ page import="edu.progra.bean.BibliografiaCurso" %>

<%
	BibliografiaCurso bibliosInfo=(BibliografiaCurso)request.getAttribute("bibliografia");
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
      <td width="260" bgcolor="#FFFFFF"> <div align="center" class="style3 style4">Bienvenido </div></td>
    </tr>
    <tr>
      <td width="222" bgcolor="#FFFFFF"><ul>
       <li class="style2"><a href="<%=request.getContextPath() %>/InformacionServlet?cod=1">Informacion de Curso</a></li>
        </ul>
        <ul class="style2">
          <li><a href="<%=request.getContextPath() %>/ContenidoServlet?cod=1">Contenido del Curso</a> </li>
        </ul>
        <ul>
          <li class="style2"><a href="<%=request.getContextPath() %>/BibliografiaServlet?cod=1">Bibliografia</a></li>
        </ul>
         <ul>
          <li class="style2"><a href="<%=request.getContextPath() %>/AyudaServlet?cod=1">Ayuda</a></li>
        </ul>
        <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
      <td  height="365" colspan="2" bgcolor="#FFFFFF"><div id="tabs">
  <ul>
    <li><a href="#tabs-1">Libro 1</a></li>
    <li><a href="#tabs-2">Libro 2</a></li>
    <li><a href="#tabs-3">Libro 3</a></li>
     <li><a href="#tabs-4">Libro 4</a></li>
  </ul>
  <div id="tabs-1">
   <table width="509" border="0">
            <tr>
              <td width="258" height="271"><img src="images/libro.png" width="255" height="245"></td>
              <td width="360"><table width="500" height="259" border="0">
                <tr>
                  <td height="34"><div align="center" class="style4"><a href="https://www.dropbox.com/sh/a43f5hzkgzd36h0/vKHAAB3OEr/BABOKv2.0.pdf" target="_blank">Libro1:</a></div></td>
                </tr>
                <tr>
                  <td><p class="style2">Descripcion</p>
                    <p class="style2">BABOK significa Business Analysis Body of Knowledge </p>
                    <p class="style2">BABOK es una guia la cual permite al alumno de software especialmente al analista, desarrollar de mejor manera su cargo. </p>
                    <p class="style2">Es muy util para poder desarrollar un software optimo. </p>
                </tr>
               </table>
     </table>
  </div>
  <div id="tabs-2">
  <table width="509" border="0">
            <tr>
              <td width="258" height="271"><img src="images/libro.png" width="255" height="245"></td>
              <td width="360"><table width="500" height="259" border="0">
                <tr>
                  <td height="34"><div align="center" class="style4"><a href="https://www.dropbox.com/sh/a43f5hzkgzd36h0/ZdM-YGRRlT/29110-5-1-2.pdf" target="_blank">Libro2:</a></div></td>
                </tr>
                <tr>
                  <td><p class="style2">Descripcion</p>
                   <p class="style2">La norma 29110 es una norma tecnina peruana para la implementacion de software aca en Per&uacute;.</p>
                    <p class="style2">Es muy util para el alumno de la FIA, ya que le</p>
                    <p class="style2"> permite desarrollar software de la manera adecuada.</p>
					</td>
                </tr>
               </table>
     </table>
  </div>
  <div id="tabs-3">
  <table width="509" border="0">
            <tr>
              <td width="258" height="271"><img src="images/libro.png" width="255" height="245"></td>
              <td width="360"><table width="500" height="259" border="0">
                <tr>
                  <td height="34"><div align="center" class="style4"><a href="https://www.dropbox.com/sh/a43f5hzkgzd36h0/403hTePbYf/capitulo%202%20pressman.pdf" target="_blank">Libro3:</a></div></td>
                </tr>
                <tr>
                  <td><p class="style2">Descripcion</p>
                   	<p class="style2">Capitulo perteneciente al libro de Pressman. </p>
                    <p class="style2">Este capitulo habla de la ingenieria de Software, el proceso del software, los modelos y la descripcion de cada uno. </p>
                    <p class="style2">Es muy util para poder desarrollar un software optimo y esta orientado a los lideres Tecnicos.. </p>
					</td>
                </tr>
               </table>
     </table>
  </div>
  <div id="tabs-4">
  <table width="509" border="0">
            <tr>
              <td width="258" height="271"><img src="images/libro.png" width="255" height="245"></td>
              <td width="360"><table width="500" height="259" border="0">
                <tr>
                  <td height="34"><div align="center" class="style4"><a href="https://www.dropbox.com/sh/a43f5hzkgzd36h0/8buiuetKmd/SWEBOK.pdf" target="_blank">Libro4:</a></div></td>
                </tr>
                <tr>
                  <td><p class="style2">Descripcion</p>
                   <p class="style2">SWEBOK significa Software Engineering Body of Knowledge. </p>
                    <p class="style2">SWEBOK un libro que es de mucha ayuda si un alumno de la carrera de ingenieria de Sistemas decide desarrollar un software.. </p>
                    <p class="style2">Es muy util para poder desarrollar un software optimo. </p>
               </td>
                </tr>
               </table>
     </table>
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