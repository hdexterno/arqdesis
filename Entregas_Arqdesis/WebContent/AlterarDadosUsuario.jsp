<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Novo Cadastro</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Dados Usuário</h3>
		<!-- Formulario para inclusao de clientes -->
		<form method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-nd-12">
					<label for="id">ID</label> <input type="text" class="form-control" name="id" id="id" value="${usuario.id}" disabled>
				</div>
				
				<div class="form-group col-nd-12">
					<label for="nome">Nome</label>
						<input type="text" class="form-control" name="nome" id="nome" required maxlength="60" value="${usuario.nome}">
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-6">
					<label for="fone">CPF</label>
						<input type="text" class="form-control" name="cpf" id="cpf" maxlength="15" required value="${usuario.cpf}" disabled>
				</div>

				<div class="form-group col-md-6">
					<label for="usuario">Usuário</label>
					<input type="text" class="form-control" name="usuario" id="usuario" required maxlength="11" value="${usuario.usuario}">
				</div>

				<div class="form-group col-md-12">
					<label for="senha">Senha</label>
					<input type="password" class="form-control" name="senha" id="senha" required maxlength="6" value="${usuario.senha}">
				</div>

				<div class="form-group col-md-12">
					<label for="endereco">Endereço</label>
					<input type="text" class="form-control" name="endereco" id="endereco" required maxlength="150" value="${usuario.endereco}">
				</div>

				<div class="form-group col-md-12">
					<label for="nome">Telefone Residencial</label>
					<input type="text" class="form-control" name="telefoneResidencial" id="telefoneResidencial" required maxlength=15 value="${usuario.telefoneResidencial}">
				</div>

				<div class="form-group col-md-12">
					<label for="nome">Telefone Celular</label>
					<input type="text" class="form-control" name="telefoneCelular" id="telefoneCelular" required maxlength=15 value="${usuario.telefoneCelular}">
				</div>

				<div class="form group col-md-12">
					<label for="acessoLivre">Acesso Livre</label>
					<select id="acessoLivreOp" name="acessoLivre">
						<option value="${usuario.acessoLivre}">${usuario.acessoLivre}</option>
						<option value="0">Não</option>
						<option value="1">Sim</option>
					</select>
				</div>

				<div class="form group col-md-12">
					<label for=autorizado>Autorizado</label>
					<select id="autorizado" name="autorizado">
						<option value="${usuario.autorizado}">${usuario.autorizado}</option>
						<option value="0">Não</option>
						<option value="1">Sim</option>
					</select>
				</div>

				<div class="form group col-md-12">
					<label for="tipoUsuario">Tipo de Usuário</label>
					<select id="tipoUsuario" name="tipoUsuario">
						<option value="${usuario.tipoUsuario}">${usuario.tipoUsuario}</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</div>

				<div class="form group col-md-12">
					<label for="periodo">Período</label>
					<select id="periodo" name="periodo">
						<option value="${usuario.periodo}">${usuario.periodo}</option>
						<option value="m">Manhã</option>
						<option value="t">Tarde</option>
						<option value="n">Noite</option>
					</select>
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="AtualizarDadosUsuario?id_selecionado=${usuario.id}" class="btn btn-primary" name="acao" value="Criar">Salvar</a>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>