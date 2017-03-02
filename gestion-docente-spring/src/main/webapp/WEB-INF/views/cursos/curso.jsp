<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		<!-- BOTON Crear//Editar formulario -->
<c:set var="men" value="Crear" />
	<c:if test="${curso.codigo > 0}" >
		<spring:message var="men"  code="form.editar" text="nombre" />
	</c:if> 
<spring:message var="seccion" code="cursos.titulo" text="curso" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />

<form:form action="save" method="post" modelAttribute="curso">
		<c:if test="${!empty curso}">
			<form:hidden path="codigo"/>
		</c:if>
		<div>
			<form:label path="nombre">
				<spring:message code="curso.nombre" />:
 			</form:label>
			<form:input path="nombre" cssErrorClass="" cssClass="" />
			<form:errors path="nombre" cssClass="" />
		</div>
		<div>
			<form:label path="finicio">Fecha inicio:</form:label>
			<form:input path="finicio" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
			<form:errors path="finicio" />
		</div>
		<div>
			<form:label path="ffin">Fecha fin:</form:label>
			<form:input path="ffin" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
			<form:errors path="ffin" />
		</div>
		<div>
			<form:label path="nhoras">Nuemero de horas:</form:label>
			<form:input path="nhoras" />
			<form:errors path="nhoras" />
		</div>
		
		<input type="submit" value="${men}">
	</form:form>
</main>
<footer>
</footer>
</body>
</html>
		</div>