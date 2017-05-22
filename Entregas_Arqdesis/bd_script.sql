create database arqdesis_entrega;
use arqdesis_entrega;

create table usuario(
	id int(10) not null auto_increment,
    nome varchar(60) not null,
    cpf char(11) not null,
    usuario char(11) not null,
    senha char(6) not null,
    endereco varchar(150) not null,
	telefone_residencial varchar(15) not null,
	telefone_celular varchar(15) not null,
	acessoLivre char(1) not null,
	autorizado char(1) not null,
	tipoUsuario char(1) not null,
	periodo char(1) not null,
	PRIMARY KEY (id),
	UNIQUE KEY cpf (cpf)
)
engine = InnoDB auto_increment = 0 default charset = utf8;

-- POPULAÇÃO TABELA USUARIO --
insert into usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo)
	values("Fernanda Chaves", "35641078520", "35641078520", "fer356", "Rua dos Virginianos, 09", "11 24578910", "11 975410236", "1", "1", "2", "n");

insert into usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo)
	values("Roberta Oliveira", "45102368792", "45102368792", "rob451", "Av. dos Taurinos, 05", "11 45789102", "11 945023785", "1", "0", "2", "t");
    
insert into usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo)
	values("Isabelle Nascimento", "34578102365", "34578102365", "isa345", "Travessa dos Piscianos, 02", "11 45201347", "11 954102367", "0", "1", "1", "m");

insert into usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo)
	values("João Cavalcanti", "41203578069", "41203578069", "joa412", "Rua dos Leoninos, 08", "11 42107856", "11 974201536", "1", "1", "1", "m");

insert into usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo)
	values("Rafael Alves", "51024736891", "51024736891", "raf510", "Alameda dos Leões, 80", "11 51023648", "11 902347510", "0", "0", "2", "n");

insert into usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo)
	values("Jefferson Pereira", "81023465897", "81023465897", "jef810", "Alameda dos Touros, 20", "11 30214756", "11 945102368", "0", "0", "1", "t");