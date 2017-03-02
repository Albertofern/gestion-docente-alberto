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


<c:choose>
		<c:when test="${not empty curso}">
		<div>
			<p>${curso.nombre}</p>
			<p>${curso.identificador}</p>
			<p></p>
		</div>
		<c:choose>
			<c:when test="${not empty curso.modulos}" >
				<table>
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Fecha Inicio</th>	
							<th>Fecha Fin</th>		
						</tr>
					</thead>
					<c:forEach var="curso" items="${curso.cursos}">
					<tbody>
						<tr>
							<td>${curso.nombre}</td>
							<td>${curso.finicio}</td>
							<td>${curso.finicio}</td>
						</tr>
					</tbody>
					
					</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
				<p>En el Curso no participan ningun alumno.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
		No se han encontrador datos del curso.
		</c:otherwise>
</c:choose>
</main>
<footer>
</footer>
</body>
</html>