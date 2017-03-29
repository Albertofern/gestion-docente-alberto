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