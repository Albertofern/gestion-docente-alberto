<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:message var="nombreApp" scope="request" code="aplicacion.nombre" />   
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<spring:url var="myestilo" value="/resources/css/style.css"></spring:url>
<link rel="stylesheet" href="${myestilo}" >
  <script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
   
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!-- libreria que me deja navegar en Internet Explorer -->
<!--[if lt IE 9]> 
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->

<meta name="viewport" content="width=device-width, initial-scale=1">



<meta charset="UTF-8">

</head>
<body>
<header class="container-fluid">
	<h1 class="col-xs-12"><span class="text-uppercase text-center">${nombreApp} - ${seccion}</span></h1> <!-- En Mayus y Centrado -->
	<nav>
		<ul>
			<li><a href="<c:url value='/alumnos'/>">G. Alumnos</a></li>
			<li><a href="<c:url value='/profesores'/>">G. Profesores</a></li>
			<li><a href="<c:url value='/clientes'/>">G. Clientes</a></li>
			<li><a href="<c:url value='/cursos'/>">G. Cursos</a></li>
		</ul>
	</nav>
	<div class="btn-group">
		<button class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown" >
			Idiomas <span class="caret"></span>
		</button>
		<ul class="dropdown-menu">
		<li>
					<a class="btn btn-default " href="?locale=es">				
					<spring:message code="idioma.castellano" text="castellano"/>
					</a>
				</li>
				<li>
					<a class="btn btn-default" href="?locale=en">
						<spring:message code="idioma.ingles" text="ingles"/>
					</a>
				</li>
				<li>
					<a class="btn btn-default" href="?locale=eu">
						<spring:message code="idioma.euskera" text="euskera"/>
					</a>
				</li>
			</ul>
		</div>
	</header> 