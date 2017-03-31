<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	<!--  <nav>
		<ul>
			<li><a href="<c:url value='/alumnos'/>">G. Alumnos</a></li>
			<li><a href="<c:url value='/profesores'/>">G. Profesores</a></li>
			<li><a href="<c:url value='/clientes'/>">G. Clientes</a></li>
			<li><a href="<c:url value='/cursos'/>">G. Cursos</a></li>
		</ul>
	</nav> -->
	<nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    		<!-- Brand and toggle get grouped for better mobile display -->
    		<div class="navbar-header">
		    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Pincha para visualizar</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
		        </button>
    		</div>
   				 <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		        <ul class="nav navbar-nav">
		      		<li><a href="<c:url value='/alumnos'/>">G. Alumnos</a></li>
		       		<li><a href="<c:url value='/profesores'/>">G. Profesores</a></li>
		        	<li><a href="<c:url value='/clientes'/>">G. Clientes</a></li>
		        	<li role="separator" class="divider"></li>
		        	<li><a href="<c:url value='/cursos'/>">G. Cursos</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<sec:authorize access="isAnonymous()">
    	<form method="POST" action="<c:url value='/login'/>">
        	Username: <input name="userId" type="text" value="${SPRING_SECURITY_LAST_USERNAME}" /> 
            Password: <input name="password" type="password" />
            <!-- 
            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
             --> 
            <input type="submit" value="Login" />
        </form>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a class="btn btn-default" href="<c:url value="/logout" />">Logout</a>
    		</sec:authorize>
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