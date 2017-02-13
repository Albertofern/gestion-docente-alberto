<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
				<!-- BOTON Crear//Editar formulario -->
<c:set var="men" value="Crear" />
<c:if test="${cliente.codigo > 0}" >
<c:set var="men" value="Editar" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Docente - ${men} Cliente</title>
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
	<form:form action="save" method="post" modelAttribute="cliente">
		<c:if test="${!empty cliente}">
			<form:hidden path="codigo"/>
		</c:if>
		<div>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" cssErrorClass="" cssClass="" />
			<form:errors path="nombre" cssClass="" />
		</div>
		<div>
			<form:label path="direccion">Dirección:</form:label>
			<form:input path="direccion"/>
			<form:errors path="direccion" />
		</div>
		<div>
			<form:label path="identificador">DNI o CIF:</form:label>
			<form:input path="identificador" cssErrorClass="" cssClass="" />
			<form:errors path="identificador" />
		</div>
		<div>
			<form:label path="telefono">Telefono:</form:label>
			<form:input path="telefono"/>
			<form:errors path="telefono" />
		</div>
		<div>
			<form:label path="email">Email:</form:label>
			<form:input path="email"/>
			<form:errors path="email" />
		</div>
		
		<input type="submit" value="${mens}">
	
	</form:form>
</main>
<footer>
</footer>
</body>
</html>