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
<form name="form1" method="post" action="LoginLogoutServlet">
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
      <td width="260" bgcolor="#FFFFFF"><table width="243" height="91" border="0" bgcolor="#FFFFFF">
        <tr>
          <td width="96"><span class="style2">Usuario:</span></td>
          <td width="215"><label>
            <input name="txt_usuario" type="text" id="txt_usuario">
          </label></td>
        </tr>
        <tr>
          <td><span class="style2">Contrase&ntilde;a:</span></td>
          <td><label>
            <input name="txt_contrase&ntilde;a" type="password" id="txt_contrase&ntilde;a">
          </label></td>
        </tr>
        <tr>
          <td colspan="2"><label>
            <div align="center">
              <input name="btn_ingresar" type="submit" class="style2" id="btn_ingresar" value="Ingresar">
              </div>
          </label></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td width="222" bgcolor="#FFFFFF"><ul>
        <li class="style2">Detalle del Curso</li>
        </ul>
        <ul class="style2">
          <li>Contenido del Curso</li>
        </ul>
        <ul>
          <li class="style2">Bibliografia</li>
        </ul>
        <ul>
          <li class="style2">Ayuda</li>
        </ul>
        <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
      <td  height="365" colspan="2" bgcolor="#FFFFFF"><a href="<%=request.getContextPath() %>/RecuperarContraServlet">Recuperar contraseña</a></td>
    </tr>
    <tr>
      <td height="112" colspan="3" bgcolor="#FFFFFF"><div align="center"><img src="images/logoo.png" width="408" height="90"></div></td>
    </tr>
  </table>
</form>
</body>
</html>