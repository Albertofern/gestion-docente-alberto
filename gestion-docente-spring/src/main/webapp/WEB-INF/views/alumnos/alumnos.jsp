<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  

<spring:message var="seccion" code="alumnos.titulo" />

<c:set scope="request" var="seccion" value="${seccion}"/>

<jsp:include page="../includes/header.jsp" />

<main class="container-fluid">
	<section class="row">
		<header class="col-xs-12"><h2>Lista de Alumnos</h2></header>
		<a class="btn btn-info" href="<c:url value='/alumnos/addAlumno'/>">Crear Alumno</a>
		<a class="btn btn-danger" href="#">Borrar Alumnos</a>
		<div class="col-xs-12">
			<!-- si se anidan las columnas tiene que haber un row -->
			<div class="row">
				<div class="col-xs-1"><input id="selectall" type="checkbox"></div>
				<div class="col-xs-2">Nombre</div> <!--  <th><spring:message code="alumno.nombre" /></th> -->
				<div class="col-xs-3">Apellidos</div>
				<div class="col-xs-2">DNI</div>
				<div class="col-xs-4"></div>
			</div>
			<c:choose>
				<c:when test="${not empty listadoAlumnos}"><!-- Cuando la lista tiene datos  -->
					<c:forEach var="alumno" items="${listadoAlumnos}">
						<div class="row">
							<div class="col-xs-1">
								<input type="checkbox" value="${alumno.codigo}">
							</div>
							<div class="col-xs-2">
								${alumno.nombre}
							</div>
							<div class="col-xs-3">
								${alumno.apellidos}
							</div>
							<div class="col-xs-2">
								${alumno.dni}
							</div>
							<div class="col-xs-4">
								<a href="<c:url value='/alumnos/${alumno.codigo}'/>">Editar</a>
								<a href="<c:url value='/alumnos/deleteAlumno/${alumno.codigo}'/>">Borrar</a>
								<a href="<c:url value='/alumnos/getInforme/${alumno.codigo }'/>">Ver Informe</a>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise><!-- Cuando la lista NO tiene datos -->
					<div class="row">No se han encontrado alumnos en la Base de Datos</div>
				</c:otherwise>
			</c:choose>		
		</div>	
	</section>
</main>

<footer>
	Ipartek S. Coop.
</footer>

</body>
</html>