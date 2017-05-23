<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Usuário Cadastrado!</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Selecione um usuário cadastrado</h3>
			<form action="ExibirDetalhesUsuario">
			<div class="form group col-md-12">
				<select name="id_selecionado">
					<c:forEach items="${lista}" var="lista">
						<option value="${lista.id}">${lista.nome}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-primary">Pesquisar</button>
			</div>
			</form>
		</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>		
	</body>
</html>