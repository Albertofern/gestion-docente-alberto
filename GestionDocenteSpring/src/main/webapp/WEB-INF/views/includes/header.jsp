<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:message var="nombreApp" scope="request" code="aplicacion.nombre" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${nombreApp} - ${seccion} </title>
</head>
<body>
<header>
	<h1>${nombreApp} - ${seccion}</h1>
	<nav>
		<ul>
			<li><a href="<c:url value='/alumnos'/>">G. Alumnos</a></li>
			<li><a href="<c:url value='/profesores'/>">G. Profesores</a></li>
			<li><a href="<c:url value='/clientes'/>">G. Clientes</a></li>
		</ul>
	</nav>
	<a href="?locale=es">				
		<spring:message code="idioma.castellano" />
	</a>
	<a href="?locale=en">
		<spring:message code="idioma.ingles" />
	</a>
	<a href="?locale=eu">
		<spring:message code="idioma.euskera" />
	</a>
</header>