<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Validador de Spring -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Encasula los objetos en un formulario. -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<main class="container-fluid">
<section class="row">
	<header class="col-xs-12">
		<h2>Datos del curso</h2>
	</header>
	<div class="col-xs-12">
		<p>Nombre: ${curso.nombre}</p>
		<p>
			F.Inicio:
			<fmt:formatDate value="${curso.finicio}" dateStyle="full" /> 
		</p>
		<p>
			F.Fin:
			<fmt:formatDate value="${curso.ffin}"  dateStyle="full" />
		</p>
		<p>Horas: ${curso.nhoras}</p>
		<p>Temario: <a href="<c:url value="resources/docs/${curso.temario}"/>" download >Ver</a></p>
		<p>Precio: ${curso.precio}</p>
		<p>Cliente: ${curso.cliente.nombre}</p>
	</div>
	<section class="col-xs-12">
		<header><h3>Listado de alumnos</h3></header>
		<c:forEach var="alumno" items="${curso.alumnos}">
			<div>
				<a href="<c:url value='/cursos/${curso.codigo}/alumnos/${alumno.codigo}'/>">${alumno.nombre}
					${alumno.apellidos} ${alumno.email}</a>
			</div>
		</c:forEach>
	</section>
</section>
<!-- Columnas de cabecera de la tabla.  --> <!-- Se comprueba si el listado de cusos asociado al cliente no está vacio. 
						 En tal caso se recorre la lista de cursos sobre el objeto curso.-->
</main>
<footer> </footer>
</body>
</html>