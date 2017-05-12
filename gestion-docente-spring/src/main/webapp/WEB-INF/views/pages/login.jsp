<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>     
<main class="container-fluid">
	<section class="row">
		<c:url value="/login.html" var="loginURL" />
		<form:form action="${loginURL}" method="post">
			<div class="input-group input-sm">
				<label>Usuario:</label>
				<input type="text" id="userId" name="userId" required/>
			</div>
			<div class="input-group input-sm">
				<label>Contraseña:</label>
				<input type="text" id="password" name="password" required/>
			</div>
			<input type="submit" value="Log In" class="btn btn-block btn-primary"/>
		</form:form>
	</section>
</main> 
