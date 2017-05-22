package model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
	private String nome, cpf, usuario, senha, endereco, telefoneResidencial, telefoneCelular, acessoLivre, autorizado,
			tipoUsuario, periodo;

	public Usuario() {
		this.id = -1;
		this.nome = null;
		this.cpf = null;
		this.usuario = null;
		this.senha = null;
		this.endereco = null;
		this.telefoneResidencial = null;
		this.telefoneCelular = null;
		this.acessoLivre = null;
		this.autorizado = null;
		this.tipoUsuario = null;
		this.periodo = null;
	}

	public Usuario(int id, String nome, String cpf, String usuario, String senha, String endereco,
			String telefoneResidencial, String telefoneCelular, String acessoLivre, String autorizado,
			String tipoUsuario, String periodo) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
		this.endereco = endereco;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
		this.acessoLivre = acessoLivre;
		this.autorizado = autorizado;
		this.tipoUsuario = tipoUsuario;
		this.periodo = periodo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getAcessoLivre() {
		return acessoLivre;
	}

	public void setAcessoLivre(String acessoLivre) {
		this.acessoLivre = acessoLivre;
	}

	public String getisAutorizado() {
		return autorizado;
	}

	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", usuario=" + usuario + ", senha=" + senha
				+ ", endereco=" + endereco + ", telefoneResidencial=" + telefoneResidencial + ", telefoneCelular="
				+ telefoneCelular + ", acessoLivre=" + acessoLivre + ", autorizado=" + autorizado + ", tipoUsuario="
				+ tipoUsuario + ", periodo=" + periodo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (acessoLivre == null) {
			if (other.acessoLivre != null)
				return false;
		} else if (!acessoLivre.equals(other.acessoLivre))
			return false;
		if (autorizado == null) {
			if (other.autorizado != null)
				return false;
		} else if (!autorizado.equals(other.autorizado))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefoneCelular == null) {
			if (other.telefoneCelular != null)
				return false;
		} else if (!telefoneCelular.equals(other.telefoneCelular))
			return false;
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null)
				return false;
		} else if (!telefoneResidencial.equals(other.telefoneResidencial))
			return false;
		if (tipoUsuario == null) {
			if (other.tipoUsuario != null)
				return false;
		} else if (!tipoUsuario.equals(other.tipoUsuario))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}