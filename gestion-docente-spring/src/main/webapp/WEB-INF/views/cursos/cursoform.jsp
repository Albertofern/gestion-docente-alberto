<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<spring:message var="men" code="form.crear" text="nombre" />
<c:if test="${curso.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if> 
<c:set scope="request" var="seccion" value="Curso"/>
<c:set scope="request" var="seccion" value="${men} ${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main class="container-fluid">
	<section class="row">
		<c:url var="sendUrl" value="/cursos/save"/>

		<c:url var="cancelUrl" value="/cursos"/>
		<header class="col-xs-12 col-md-10 col-md-offset-2"><h2>${seccion}</h2></header>
		<div class="container-fluid">
			<form:form action="${sendUrl}" enctype="multiporrt/form-data" method="post" cssClass="form-horizontal" modelAttribute="curso" enctype="multipart/form-data">
				<c:if test="${!empty curso}">
					<form:hidden path="codigo"/>
				</c:if>
				<div class="form-group">
						<form:label path="nombre" cssClass="control-label  col-xs-2"><spring:message code="form.nombre" text="Nombre"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="nombre" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="nombre" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="identificador" cssClass="control-label  col-xs-2">Idenficador</form:label>
						<div class="col-xs-4">
							<form:input type="text" path="identificador" cssClass="form-control" cssErrorClass="form-control text-danger"/>
						</div>
					<form:errors path="identificador" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="finicio" cssClass="control-label col-xs-2"><spring:message code="form.fInicio" text="F. Inicio"/></form:label>
					<div class="col-xs-4">
						<form:input type="text" path="finicio" cssClass="form-control" cssErrorClass="text-danger"/>
					</div>
					<form:errors path="finicio" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="ffin" cssClass="control-label  col-xs-2"><spring:message code="form.fFin" text="F. Fin"/></form:label>
						<div class="col-xs-4">
							<form:input type="text" path="ffin" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="ffin" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="nhoras" cssClass="control-label  col-xs-2"><spring:message code="form.nHoras" text="Núm. Horas"/></form:label>
						<div class="col-xs-4">
							<form:input path="nhoras" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="nhoras" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
						<form:label path="precio" cssClass="control-label  col-xs-2"><spring:message code="form.precio" text="Precio"/></form:label>
						<div class="col-xs-4">
							<form:input path="precio" cssClass="form-control" cssErrorClass="text-danger"/>
						</div>
						<form:errors path="precio" cssClass="text-danger col-xs-6"></form:errors>
				</div>
				<div class="form-group">
             		<form:label path="temario" cssClass="control-label  col-xs-2">Temario:</form:label>
             		<div class="col-xs-4">
             			<c:set var="string" value="${curso.temario}" />
    						<c:set var="names" value="${fn:split(string, '/')}" />
    						<c:set var="len" value="${fn:length(numList)}"/>
    						<c:set var="value" value="${names[len-1]}" />
    						${value}
 						<form:input value="${value}" path="temario" disabled="disabled" cssClass="form-control" cssErrorClass="text-danger"/>
 					</div>
 					<form:errors path="temario" cssClass="text-danger col-xs-6"></form:errors>
 					 <label class="btn btn-primary">
                 		Examinar&hellip; <input type="file" id="fichero" name="fichero" style="display: none;"><!-- name del RequestParam del controller save -->
            		</label>
            	</div>				
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="profesor">Profesor:</form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="profesor">
			               <form:option value="0" label="Elija un profesor"/>
							<form:options items="${listadoProfesores}" itemValue="codigo" itemLabel="nombre" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="profesor"/>   
				</div>
				<div class="form-group">
					<form:label cssClass="control-label col-xs-2" path="cliente">Cliente:</form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="cliente">
			               <form:option value="0" label="Elija un cliente"/>
							<form:options items="${listadoClientes}" itemValue="codigo" itemLabel="nombre" />
			            </form:select> 
		            </div>
		            <form:errors cssClass="text-error"  path="cliente"/>   
				</div>
				<div class="col-xs-12">
					<form:label path="alumnos" class="col-xs-2">Alumnos:</form:label>
					<div class="col-xs-4">
						<form:select cssClass="form-control" path="alumnos" multiple="true">
						<form:options items="${listadoAlumnos}" itemValue="codigo" itemLabel="nombre"/>
						</form:select>
					</div>
						<form:errors path="alumnos" class="text-error col-xs-6"/>
				</div> 
				<div class="form-group">
					<div class="col-md-offset-3">
						<button type="submit" class="btn btn-success">${men}</button>
						<a class="btn btn-warning" href="${cancelUrl}">Cancelar</a>
					</div>
				</div>
				<form:hidden path="activo"/>
			</form:form>
		</div>
	</section>
</main>