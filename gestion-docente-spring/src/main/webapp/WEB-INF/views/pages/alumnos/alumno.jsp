<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<!-- @ModelAttribute("alumno") de AlumnoController -->
	<form:form action="save" method="post" cssClass="" modelAttribute="alumno">
		<c:if test="${!empty alumno}">
			<form:hidden path="codigo"/>
		</c:if>
		<div>
			<form:label cssClass="" path="nombre">
				<spring:message code="alumno.nombre" />:
 			</form:label>
			<form:input placeholder="Introduzca su nombre" path="nombre" cssErrorClass="text-danger" cssClass="" />
			<form:errors path="nombre" cssClass="text-danger" />
		</div>
		<div>
			<form:label path="apellidos"><spring:message code="alumno.apellidos" />:</form:label>
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
			<form:input path="fNacimiento" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
			<form:errors path="fNacimiento" />
		</div>
		<div>
			<form:label path="direccion">Direcci�n:</form:label>
			<form:input path="direccion"/>
			<form:errors path="direccion" />
		</div>
		<div>
			<form:label path="poblacion">Poblaci�n:</form:label>
			<form:input path="poblacion"/>
			<form:errors path="poblacion" />
		</div>
		<div>
			<form:label path="codigoPostal">Codigo Postal:</form:label>
			<form:input path="codigoPostal" />
			<form:errors path="codigoPostal" />
		</div>
		<div>
			<form:label path="nHermanos">Numero de hermanos:</form:label>
			<form:input path="nHermanos"/>
			<form:errors path="nHermanos"/>
		</div>
		
	
		<input type="submit" value="${men}">
	</form:form>