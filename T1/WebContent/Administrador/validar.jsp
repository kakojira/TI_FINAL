<%
	if(session.getAttribute("nombreadm") == null){
		response.sendRedirect("login.jsp");
	}
%>