<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
				<!-- BOTON Crear//Editar formulario -->
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${cliente.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="cliente.titulo" text="cliente" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
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
			<form:label path="codigoPostal">Codigo postal::</form:label>
			<form:input path="codigoPostal"/>
			<form:errors path="codigoPostal" />
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
		
		<input type="submit" value="${men}">
	
	</form:form>
</main>
<footer>
</footer>
</body>
</html>