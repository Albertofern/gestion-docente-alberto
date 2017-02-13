<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<spring:message var="seccion" code="profesores.titulo" />
<c:set scope="request" var="seccion" value="${seccion}"/>
<jsp:include page="../includes/header.jsp" />
<main>
	<a href="<c:url value='/profesores/addProfesor'/>">Crear Profesor</a>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th></th>
			</tr>	
		</thead>
		<tbody>
		
	<c:choose>
		<c:when test="${not empty listadoProfesores}"><!-- Cuando la lista tiene datos  -->
			<c:forEach var="profesor" items="${listadoProfesores}">
			<tr>	
				<td>${profesor.nombre}</td> 
				<td>${profesor.apellidos}</td> 
				<td>
						<a href="<c:url value='/profesores/${profesor.codigo}'/>">Editar</a>
						<a href="<c:url value='/profesores/deleteProfesor/${profesor.codigo}'/>">Borrar</a>

				</td> 
			</tr>	
			</c:forEach>
		</c:when>
		<c:otherwise><!-- Cuando la lista NO tiene datos -->
			<tr>
				No se han encontrado profesores en la Base de Datos
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