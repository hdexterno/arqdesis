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
		<h3 class="page-header">Detalhes de Usuário</h3>
		<!--  Opções ao usuário -->
		<div class="col-md-12">
			ID: ${usuario.id}<br/>
			Nome: ${usuario.nome}<br/>
			CPF: ${usuario.cpf}<br/>
			Usuário: ${usuario.usuario}<br/>
			Endereço: ${usuario.endereco}<br/>
			Telefone Residencial: ${usuario.telefoneResidencial}<br/>
			Telefone Celular: ${usuario.telefoneCelular}<br/>
			Acesso Livre: ${usuario.acessoLivre}<br/>
			Autorizado: ${usuario.autorizado}<br/>
			Tipo de Usuário: ${usuario.tipoUsuario}<br/>
			Período: ${usuario.periodo}
			<br/><br/>
			<a class="btn btn-default" href="AlterarUsuario?id=${usuario.id}">Alterar dados</a>
			<a class="btn btn-default" href="DeletarUsuario?id=${usuario.id}">Deletar usuário</a>
			<a class="btn btn-primary" href="index.jsp">Início</a> 
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>