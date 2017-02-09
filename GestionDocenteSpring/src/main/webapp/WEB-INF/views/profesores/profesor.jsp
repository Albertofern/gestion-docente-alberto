<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Docente - Profesor</title>
</head>
<body>
	<!-- @ModelAttribute("profesor") de ProfesorController -->
	<form:form action="save" method="post" commandName="profesor">
		<c:if test="${!empty profesor}">
			<form:hidden path="codigo"/>
		</c:if>
		<div>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre" cssErrorClass="" cssClass="" />
			<form:errors path="nombre" cssClass="" />
		</div>
		<div>
			<form:label path="apellidos">Apellidos:</form:label>
			<form:input path="apellidos" cssErrorClass="" cssClass="" />
			<form:errors path="apellidos"/>
		</div>
		<div>
			<form:label path="dni">DNI:</form:label>
			<form:input path="dni"/>
			<form:errors path="dni" />
		</div>
		<div>
			<form:label path="nSS">nSS:</form:label>
			<form:input path="nSS"/>
			<form:errors path="nSS" />
		</div>
		<div>
			<form:label path="email">Email:</form:label>
			<form:input path="email"/>
			<form:errors path="email" />
		</div>
		<div>
			<form:label path="telefono">Telefono:</form:label>
			<form:input path="telefono"/>
			<form:errors path="telefono" />
		</div>
		<div>
			<form:label path="fNacimiento">F. Nacimiento:</form:label>
			<form:input path="fNacimiento" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
			<form:errors path="fNacimiento" />
		</div>
		<div>
			<form:label path="direccion">Dirección:</form:label>
			<form:input path="direccion"/>
			<form:errors path="direccion" />
		</div>
		<c:set var="mens" value="Crear" />
		<c:if test="${profesor.codigo > 0}">
			<c:set var="mens" value="Editar" />
		</c:if>
		<input type="submit" value="${mens}">
	</form:form>
</body>
</html>