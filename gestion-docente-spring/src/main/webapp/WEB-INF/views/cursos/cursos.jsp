<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set scope="request" var="seccion" value="Listado de Cursos"/>

<jsp:include page="../includes/header.jsp" />
<main>
	<c:forEach var="" items="${listadoCursos}">
		<!-- De aqui tenemos acceso a todos los atributos -->
		<div>
			<a href="<c:url value='/cursos/${curso.codigo}'/>">${curso.nombre }</a>
			${curso.ffnicio}
			${curso.ffin}
		</div>	
	
	</c:forEach>

</main>
<body>

</body>
<footer>
</footer>
</html>