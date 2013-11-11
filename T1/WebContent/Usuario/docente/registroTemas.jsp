<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<!--
.style2 {font-family: "Comic Sans MS"}
.style3 {
	font-size: 36px;
	font-family: "Comic Sans MS";
	color: #990000;
}
-->
</style>
</head>
<body>
<form name="form1" method="post" action="RegistroTemaDocente">
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
            <td width="260" bgcolor="#FFFFFF"> <div align="center" class="style3 style4">Bienvenido Docente </div></td>

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
      <td  height="365" colspan="2" bgcolor="#FFFFFF"><table width="520" border="0">
        <tr>
          <th height="48" colspan="2" class="style2" scope="col">Registro Tema </th>
          </tr>
        <tr>
          <td width="185" height="48" class="style2">Nombre: </td>
          <td width="319" class="style2"><label>
            <input name="txt_nombre" type="text" id="txt_nombre">
          </label></td>
        </tr>
        <tr>
          <td height="42" class="style2">Link : </td>
          <td class="style2"><label>
            <input name="txt_link" type="text" id="txt_link">
          </label></td>
        </tr>
        <tr>
          <td height="37" class="style2">Semana: </td>
          <td class="style2"><label>
            <input name="txt_semana" type="text" id="txt_semana">
          </label></td>
        </tr>
        <tr>
          <td height="41" class="style2">Unidad:</td>
          <td height="41" class="style2"><label>
            <input name="txt_unidad" type="text" id="txt_unidad">
          </label></td>
        </tr>
        <tr>
          <td height="41" colspan="2" class="style2"><label>
            <div align="center">
              <input name="btn_tema" type="submit" class="style2" id="btn_tema" value="Agregar">
              </div>
          </label></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="112" colspan="3" bgcolor="#FFFFFF"><div align="center"><img src="images/logoo.png" width="408" height="90"></div></td>
    </tr>
  </table>
</form>
</body>
</html>