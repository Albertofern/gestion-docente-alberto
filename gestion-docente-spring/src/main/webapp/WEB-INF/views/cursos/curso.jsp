<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!-- Validador de Spring -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Encasula los objetos en un formulario. -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:set scope="request" var="seccion" value="Datos del curso"/>
<jsp:include page="../includes/header.jsp" />
	<main>
		<div>
			Codigo: ${curso.identificador} 
			Nombre: ${curso.nombre} 
		</div>
			<c:forEach var="cdetalle" items="${curso.modulos}">
				<!-- Línea de datos de cursodetalle. -->
				<div>
					Codigo del modulo: ${cdetalle.modulo.codigo}
				 	Nombre del modulo: ${cdetalle.modulo.nombre}
					Numero de horas: ${cdetalle.modulo.nhoras} hrs.
				</div>

							<!-- Columnas de cabecera de la tabla.  -->

						
	
						<!-- Se comprueba si el listado de cusos asociado al cliente no está vacio. 
						 En tal caso se recorre la lista de cursos sobre el objeto curso.-->	

							<c:forEach var="alumno" items="${cdetalle.imparticion.alumnos}">
								<!-- Línea de datos de curso. 
						     		Es necesario llamar a las propiedades con value porque se esta trabajando 
						     		con mapas en vez de listas.-->
						
									<!-- Celda con el d.n.i. del alumno. -->
									${alumno.dni}
									<!-- Celda con el nombre del alumno. -->
									${alumno.nombre}
									<!-- Celda con los apellidos del alumno. -->
									${alumno.apellidos}
				
							</c:forEach>
			</c:forEach>

	</main>
	<footer>
	
	</footer>
</body>
</html>