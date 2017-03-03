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
		<section>
			<header><h2>Datos del curso:</h2></header> 
				Codigo: ${curso.identificador} 
				Nombre: ${curso.nombre} 
				Fecha Inicio: ${curso.finicio}
				Fecha fin: ${curso.ffin}
		</section>
		
		<section>
			<header><h3>Listado de Modulos</h3></header>
			<c:forEach var="cdetalle" items="${curso.modulos}">
				<div>
					Codigo del modulo: ${cdetalle.modulo.codigo}
				 	Nombre del modulo: ${cdetalle.modulo.nombre}
					Numero de horas: ${cdetalle.modulo.nhoras} hrs.
				</div>
			</c:forEach>				
				
		</section>
							<!-- Columnas de cabecera de la tabla.  -->

						
	
						<!-- Se comprueba si el listado de cusos asociado al cliente no está vacio. 
						 En tal caso se recorre la lista de cursos sobre el objeto curso.-->	

		
		<section>
			<header><h4>Listado de alumnos</h4></header>		
				<c:forEach var="alumno" items="${curso.alumnos}">
					<div>
						${alumno.nombre} ${alumno.apellidos} ${alumno.email}
					</div>
				</c:forEach>
		</section>				
			
	</main>
	<footer>
	
	</footer>
</body>
</html>