<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section>
	<header><h2>Informacion de Debug</h2></header>
		<div>
			<p>URL =${URL}</p>
			<p>Exception = ${exception.message}</p>
			
			<!-- Tratariamos esta trace para que spring secury no nos la enseñe si no somos admin -->
			<c:forEach items="${exception.strackTrace}" var="st">
				${st}
			</c:forEach>
		</div>
</section>