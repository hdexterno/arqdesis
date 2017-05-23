<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ID ${usuario.id}</title>
</head>
<body>
	<form action="AtualizarDadosUsuario">
		<label for="id">ID do usuário</label>
		<input type="text" id="id" name="id" value="${id}" disabled />
		<br /><br />
		<label for="nome">Nome</label>
		<input type="text" id="nome" name="nome" value="${usuario.nome}" />
		<br /><br />
		<label for="cpf">CPF</label>
		<input type="text" id="cpf" name="cpf" value="${usuario.cpf}" disabled />
		<br/><br />
		<label for="usuario">Usuário</label>
		<input type="text" id="usuario" name="usuario" value="${usuario.usuario}" />
		<br /><br />
		<label for="senha">Senha</label>
		<input type="text" id="senha" name="senha" value="${usuario.senha}" />
		<br /><br />
		<label for="endereco">Endereço</label>
		<input type="text" id="endereco" name="endereco" value="${usuario.endereco}" />
		<br /><br />
		<label for="telefoneResidencial">Telefone Residencial</label>
		<input type="text" id="telefoneResidencial" name="telefoneResidencial" value="${usuario.telefoneResidencial}" />
		<br /><br />
		<label for="telefoneCelular">Telefone Celular</label>
		<input type="text" id="telefoneCelular" name="telefoneCelular" value="${usuario.telefoneCelular}" />
		<br /><br />
		<label for="acessoLivre">Acesso Livre</label>
		<br />
		<select id="acessoLivreOp" name="acessoLivre">
			<option value="${usuario.acessoLivre}" selected>${usuario.acessoLivre}</option>
			<option value="0">Não</option>
			<option value="1">Sim</option>
		</select>
		<br /><br /> 
		<label for=autorizado>Autorizado</label>
		<br />
		<select name="autorizado">
			<option value="${usuario.autorizado}" selected>${usuario.autorizado}</option>
			<option value="0">Não</option>
			<option value="1">Sim</option>
		</select>
		<br /><br />
		<label for="tipoUsuario">Tipo de Usuário</label>
		<br />
		<select name="tipoUsuario">
			<option value="${usuario.tipoUsuario}" selected>${usuario.tipoUsuario}</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
		<br /><br />
		<label for="periodo">Período</label>
		<br />
		<select name="periodo">
			<option value="${usuario.periodo}" selected>${usuario.periodo}</option>
			<option value="m">Manhã</option>
			<option value="t">Tarde</option>
			<option value="n">Noite</option>
		</select>
		<br /><br />
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>