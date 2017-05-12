<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<a href="<c:url value='/clientes/addCliente'/>">Crear Cliente</a>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Email</th>
				<th>Identificador</th>
				<th>T�lefono</th>
			</tr>	
		</thead>
	<tbody>	
	<c:choose>
		<c:when test="${not empty listadoClientes}"> <!-- Cuando la lista tiene datos  -->
			<c:forEach var="cliente" items="${listadoClientes}">
			<tr>	
				<td>${cliente.nombre}</td> 
				<td>${cliente.email}</td>
				<td>${cliente.identificador}</td> 
				<td>${cliente.telefono}</td>
				<td>
					<a href="<c:url value='/clientes/${cliente.codigo}'/>">Editar</a>
					<a href="<c:url value='/clientes/deleteCliente/${cliente.codigo}'/>">Borrar</a>
					<a href="<c:url value='/clientes/getInforme/${cliente.codigo }'/>">Ver Informe</a>

				</td>
				
			</tr>	
			</c:forEach>
		</c:when>
		<c:otherwise><!-- Cuando la lista NO tiene datos -->
			<tr>
				<td colspan="4">No se han encontrado clientes en la Base de Datos</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	</table>