<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Cadastro</title>
</head>
<body>
	<form action="CadastrarUsuario">
		<label for="nome">Nome</label>
		<input type="text" id="nome" name="nome" />
		<br /><br />
		<label for="cpf">CPF</label>
		<input type="text" id="cpf" name="cpf" />
		<br/><br />
		<label for="usuario">Usuário</label>
		<input type="text" id="usuario" name="usuario" />
		<br /><br />
		<label for="senha">Senha</label>
		<input type="text" id="senha" name="senha" />
		<br /><br />
		<label for="endereco">Endereço</label>
		<input type="text" id="endereco" name="endereco" />
		<br /><br />
		<label for="telefoneResidencial">Telefone Residencial</label>
		<input type="text" id="telefoneResidencial" name="telefoneResidencial" />
		<br /><br />
		<label for="telefoneCelular">Telefone Celular</label>
		<input type="text" id="telefoneCelular" name="telefoneCelular" />
		<br /><br />
		<label for="acessoLivre">Acesso Livre</label>
		<select id="acessoLivreOp" name="acessoLivre">
			<option value="0">Não</option>
			<option value="1">Sim</option>
		</select>
		<br /><br /> 
		<label for=autorizado>Autorizado</label>
		<select name="autorizado">
			<option value="0">Não</option>
			<option value="1">Sim</option>
		</select>
		<br /><br />
		<label for="tipoUsuario">Tipo de Usuário</label>
		<select name="tipoUsuario">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
		<br /><br />
		<label for="periodo">Período</label>
		<select name="periodo">
			<option value="m">Manhã</option>
			<option value="t">Tarde</option>
			<option value="n">Noite</option>
		</select>
		<br />
		<br />
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>