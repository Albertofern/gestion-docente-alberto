<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Docente - Listado Clientes</title>
</head>
<body>
<header>
	<h1>Gestion Docente - ${men} Cliente</h1>
 	<nav>
 		<ul>
 			<li><a href="<c:url value='/alumnos'/>">G. Alumnos</a></li>
 			<li><a href="<c:url value='/profesores'/>">G. Profesores</a></li>
 			<li><a href="<c:url value='/clientes'/>">G. Clientes</a></li>
 		</ul>
 	</nav>	
 </header>
 <main>
	<a href="clientes/addCliente">Crear</a>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th></th>
			</tr>	
		</thead>
	<tbody>	
	<c:choose>
		<c:when test="${not empty listadoClientes}"><!-- Cuando la lista tiene datos  -->
			<c:forEach var="cliente" items="${listadoClientes}">
			<tr>	
				<td>${cliente.nombre}</td> 
				<td>${cliente.email}</td>
				<td>${cliente.identificador}</td> 
				<td>${cliente.telefono}</td>
				<td>
					<a href="cliente/${cliente.codigo}">Editar</a>
					<a href="cliente/deleteCliente/${cliente.codigo}">Borrar</a>
				</td>
				
			</tr>	
			</c:forEach>
		</c:when>
		<c:otherwise><!-- Cuando la lista NO tiene datos -->
			<tr>
				<td colspan="3">No se han encontrado clientes en la Base de Datos</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
</main>
</body>
</html>