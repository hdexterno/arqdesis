<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Usuários</title>
	</head>
	<body>
			<a href="index.html">Home</a><br/>
			Escolha o usuário:<br/>
			<form action="ExibirDetalhesUsuario">
				<select name="id_selecionado">
					<c:forEach items="${lista}" var="lista">
						<option value="${lista.id}">${lista.nome}</option>
					</c:forEach>
				</select>
				<input value="OK" type="submit"/>
			</form>
	</body>
</html>