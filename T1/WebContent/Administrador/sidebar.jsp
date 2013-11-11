<ul>
	<li>
		<h3><a href="<%=request.getContextPath() %>/Administrador/inicio.jsp" class="folder_table">INICIO</a></h3>
	</li>
	<li>
		<h3><a href="#" class="folder_table">USER</a></h3>
		<ul>
 			<li><a href="<%=request.getContextPath() %>/UsuarioServlet?funcion=agregar" class="addorder">Agregar</a></li>
			<li><a href="<%=request.getContextPath() %>/UsuarioServlet?funcion=listar" class="shipping">Listar</a></li>
        </ul>
	</li>
	<li>
		<h3><a href="#" class="folder_table">LIBROS</a></h3>
		<ul>
 			<li><a href="<%=request.getContextPath() %>/CRUDBibliografiaServlet?funcion=agregar" class="addorder">Agregar</a></li>
			<li><a href="<%=request.getContextPath() %>/CRUDBibliografiaServlet?funcion=listar" class="shipping">Listar</a></li>
        </ul>
	</li>
	<li>
		<h3><a href="#" class="folder_table">TEMAS</a></h3>
		<ul>
 			<li><a href="<%=request.getContextPath() %>/CRUDContenidoServlet?funcion=agregar" class="addorder">Agregar</a></li>
			<li><a href="<%=request.getContextPath() %>/CRUDContenidoServlet?funcion=listar" class="shipping">Listar</a></li>
        </ul>
	</li>
	<li>
		<h3><a href="#" class="folder_table">DETALLES</a></h3>
		<ul>
 			<li><a href="<%=request.getContextPath() %>/CRUDInformacionServlet?funcion=agregar" class="addorder">Agregar</a></li>
			<li><a href="<%=request.getContextPath() %>/CRUDInformacionServlet?funcion=listar" class="shipping">Listar</a></li>
        </ul>
	</li>
</ul>  