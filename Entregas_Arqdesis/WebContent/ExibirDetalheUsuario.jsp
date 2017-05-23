<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Informações de ${usuario.nome}</title>
	</head>
	<body>
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
		Período: ${usuario.periodo}<br/>
		<br/><br/>
		<a href="AlterarUsuario?id=${usuario.id}">Alterar dados</a>
		<a href="DeletarUsuario?id=${usuario.id}">Deletar usuário</a>
		<a href="index.html">OK</a>
	</body>
</html>