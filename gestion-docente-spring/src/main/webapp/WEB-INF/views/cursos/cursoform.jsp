<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${curso.codigo > 0}" >
    <spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="cursos.titulo" text="curso" />
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main>
		<!-- FORMULARIO DE SPRING -->
    <form:form action="save" method="post" commandName="curso">
        <c:if test="${!empty curso}">
            <form:hidden path="codigo"/>
        </c:if>
        <div>
            <form:label  path="nombre">Nombre:</form:label>
            <form:input placeholder="Introduzca su nombre" path="nombre" cssErrorClass="text-danger" cssClass=""/>
            <form:errors path="nombre" cssClass="text-danger"/>
        </div>
        <div>
            <form:label path="identificador">identificador:</form:label>
            <form:input path="identificador"/>
            <form:errors path="identificador"/>
        </div>
        <div>
            <form:label path="nHoras">Duracion:</form:label>
            <form:input path="nHoras"/>
            <form:errors path="nHoras"/>
        </div>
        <div>
            <form:label path="temario">Temario:</form:label>
            <form:input path="temario"/>
            <form:errors path="temario"/>
        </div> 
        <div>
            <form:label path="fInicio">Fecha de inicio:</form:label>
            <form:input path="fInicio" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
            <form:errors path="fInicio"/>   
        </div>
        <div>
            <form:label path="fFin">Fecha de fin:</form:label>
            <form:input path="fFin" placeholder="dd/MM/yyyy" pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}"/>
            <form:errors path="fFin"/>  
        </div>
        <div>
            <form:label path="precio">Precio:</form:label>
            <form:input path="precio"/>
            <form:errors path="precio"/>
        </div>
        <c:set var="men" value="Crear"/>
        <c:if test="${curso.codigo > 0 }">
            <c:set var="men" value="Save"/>
        </c:if>
        <input type="submit" value="${men}">
    </form:form>
</main>
<footer>
</footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:message scope="request" var="seccion" code="menu.cursos"/>
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
		<section class="row">
			<header class="col-xs-12 col-md-10 col-md-offset-2"><h2>Formulario Curso</h2></header>
			<div class="container-fluid">
				<form:form class="form-horizontal" action="save" method="post" commandName="curso" >
				<c:set var="v" value="Crear"></c:set>
				<c:if test="${not empty curso} ">
						<c:if test="${curso.codigo>0}">
						<c:set var="v" value="Editar"/>
						<div class="form-group">
							
							<form:label path="codigo" cssClass="control-label col-xs-2"><spring:message code="form.codigo" text="Codigo"/></form:label>
							<div class="col-xs-4">
							<form:input path="codigo" cssClass="form-control" />
							</div>
	
						</div>	
						</c:if>   
				</c:if>
				<div class="form-group">
					<form:label path="nombre" cssClass="control-label  col-xs-2">Nombre</form:label>
					<div class="col-xs-4">
						<form:input path="nombre" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
				<form:errors path="nombre" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="identificador" cssClass="control-label  col-xs-2">Identificador</form:label>
					<div class="col-xs-4">
						<form:input path="identificador" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="identificador" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="finicio" cssClass="control-label  col-xs-2">F. Inicio</form:label>
					<div class="col-xs-4">
						<form:input path="finicio" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="finicio" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="ffin" cssClass="control-label  col-xs-2">F. Fin</form:label>
					<div class="col-xs-4">
						<form:input path="ffin" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="ffin" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="nhoras" cssClass="control-label  col-xs-2">Núm. Horas</form:label>
					<div class="col-xs-4">
						<form:input path="nhoras" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="nhoras" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="precio" cssClass="control-label  col-xs-2">Precio</form:label>
					<div class="col-xs-4">
						<form:input path="precio" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="precio" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-default col-xs-offset-3 col-xs-1" value="${v}"/>
				</div>
			</form:form>
		</div>
	</section>
</main>
</body>
</html>