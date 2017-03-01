<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  

<spring:message var="seccion" code="alumnos.titulo" />

<c:set scope="request" var="seccion" value="${seccion}"/>

<jsp:include page="../includes/header.jsp" />

<main>
	<a href="<c:url value='/alumnos/addAlumno'/>">Crear Alumno</a>
	<table>
		<thead>
			<tr>
				<!--  <th><spring:message code="alumno.nombre" /></th> -->
				<th>Nombre</th>
				<th>Apellidos</th>
			
			</tr>	
		</thead>
		
	<tbody>	
	<c:choose>
		<c:when test="${not empty listadoAlumnos}"><!-- Cuando la lista tiene datos  -->
			<c:forEach var="alumno" items="${listadoAlumnos}">
			<tr>	
				<td>${alumno.nombre}</td> 
				<td>${alumno.apellidos}</td> 
				<td>${alumno.dni}</td>
				<td>
					<a href="<c:url value='/alumnos/${alumno.codigo}'/>">Editar</a>
					<a href="<c:url value='/alumnos/deleteAlumno/${alumno.codigo}'/>">Borrar</a>
					<a href="<c:url value='/alumnos/getInforme/${alumno.codigo }'/>">Ver Informe</a>
				</td>
				
			</tr>	
			</c:forEach>
		</c:when>
		<c:otherwise><!-- Cuando la lista NO tiene datos -->
			<tr>
				<td colspan="3">No se han encontrado alumnos en la Base de Datos</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>
</main>

<footer>
	Ipartek S. Coop.
</footer>

</body>
</html>