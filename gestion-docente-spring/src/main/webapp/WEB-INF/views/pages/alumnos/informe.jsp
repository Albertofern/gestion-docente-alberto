<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>       
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
		<c:when test="${not empty alumno}">
		<div>
			<p>${alumno.nombre}</p>
			<p>${alumno.email}</p>
			<p></p>
		
		
		</div>
		<c:choose>
			<c:when test="${not empty alumno.cursos}" >
				<table>
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Horas</th>	
							<th>Precio</th>		
						</tr>
					</thead>
					<c:forEach var="curso" items="${alumno.cursos}">
					<tbody>
						<tr>
							<td>${curso.nombre}</td>
							<td>${curso.nhoras}</td>
							<td>${curso.precio}</td>
						</tr>
					</tbody>
					
					</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
				<p>El Alumno no nos ha participado en ningun curso.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
		No se han encontrador datos del cliente
		</c:otherwise>
</c:choose>