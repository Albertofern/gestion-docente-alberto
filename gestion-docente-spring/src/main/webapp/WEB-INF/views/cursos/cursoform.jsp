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