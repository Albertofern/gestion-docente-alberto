<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		<!-- BOTON Crear//Editar formulario -->
<c:set var="men" value="Crear" />
	<c:if test="${alumno.codigo > 0}" >
		<spring:message var="men"  code="form.editar" text="nombre" />
	</c:if> 
<spring:message var="seccion" code="alumnos.titulo" text="alumno" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main>
	<!-- @ModelAttribute("alumno") de AlumnoController -->
	<form:form action="save" method="post" modelAttribute="alumno">
		<c:if test="${!empty alumno}">
			<form:hidden path="codigo"/>
		</c:if>
		<div>
			<form:label path="nombre">
				<spring:message code="alumno.nombre" />:
 			</form:label>
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
			<form:label path="email">Email:</form:label>
			<form:input path="email"/>
			<form:errors path="email" />
		</div>
		<div>
			<form:label path="telefono">Telefono:</form:label>
			<form:input path="telefono" pattern="[0-9]{9}"/>
			<form:errors path="telefono" />
		</div>
		<div>
			<form:label path="fNacimiento">F. Nacimiento:</form:label>
			<form:input path="fNacimiento" placeholder="dd/mm/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
			<form:errors path="fNacimiento" />
		</div>
		<div>
			<form:label path="direccion">Dirección:</form:label>
			<form:input path="direccion"/>
			<form:errors path="direccion" />
		</div>
		<div>
			<form:label path="poblacion">Población:</form:label>
			<form:input path="poblacion"/>
			<form:errors path="poblacion" />
		</div>
		<div>
			<form:label path="codigopostal">Codigo Postal:</form:label>
			<form:input path="codigopostal" />
			<form:errors path="codigopostal" />
		</div>
		<div>
			<form:label path="nHermanos">Numero de hermanos:</form:label>
			<form:input path="nHermanos"/>
			<form:errors path="nHermanos"/>
		</div>
		
	
		<input type="submit" value="${men}">
	</form:form>
</main>
<footer>
</footer>
</body>
</html>