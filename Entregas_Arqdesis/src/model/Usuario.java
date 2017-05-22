package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
	private int id;
	private String nome, cpf, usuario, senha, endereco, telefoneResidencial, telefoneCelular, acessoLivre, autorizado, tipoUsuario, periodo;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	public Usuario(){
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

	public Usuario(int id, String nome, String cpf, String usuario, String senha, String endereco, String telefoneResidencial,
			String telefoneCelular, String acessoLivre, String autorizado, String tipoUsuario, String periodo) {
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

	//Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/arqdesis_entrega?user=alunos&password=alunos");
	}
	
	public void criar(){
		String sqlInsert = "INSERT INTO usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	//usando o try with resources do Java 7, que fecha o que abriu
	try(Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert)){
		stm.setString(1, getNome());
		stm.setString(2, getCpf());
		stm.setString(3, getUsuario());
		stm.setString(4, getSenha());
		stm.setString(5, getEndereco());
		stm.setString(6, getTelefoneResidencial());
		stm.setString(7, getTelefoneCelular());
		stm.setString(8, getAcessoLivre());
		stm.setString(9, getisAutorizado());
		stm.setString(10, getTipoUsuario());
		stm.setString(11, getPeriodo());
		stm.execute();
		
		String sqlQuery  = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
			ResultSet rs = stm2.executeQuery();) {
			if(rs.next()){
				setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} catch(SQLException e){
		e.printStackTrace();
	}
	}
	
	public void atualizar(){
		String sqlUpdate = "UPDATE usuario SET nome=?, cpf=?, usuario=?, senha=?, endereco=?, telefone_residencial=?, telefone_celular=?,"
				+ "acessoLivre=?, autorizado=?, tipoUsuario=?, periodo=? WHERE id=?";
		//usando o try with resources do Java 7, que fecha o que abriu
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
			stm.setString(1, getNome());
			stm.setString(2, getCpf());
			stm.setString(3, getUsuario());
			stm.setString(4, getSenha());
			stm.setString(5, getEndereco());
			stm.setString(6, getTelefoneResidencial());
			stm.setString(7, getTelefoneCelular());
			stm.setString(8, getAcessoLivre());
			stm.setString(9, getisAutorizado());
			stm.setString(10, getTipoUsuario());
			stm.setString(11, getPeriodo());
			stm.setInt(12, getId());
			stm.execute();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void excluir(){
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		//usando o try with resources do Java 7, que fecha o que abriu
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete)){
			stm.setInt(1, getId());
			stm.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void carregar(){
		String sqlSelect = "SELECT * FROM usuario WHERE id = ?";
		//usando o try with resources do Java 7, que fecha o que abriu
		try(Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setInt(1, getId());
			try(ResultSet rs = stm.executeQuery()){
				if(rs.next()){
					setNome(rs.getString("nome"));
					setCpf(rs.getString("cpf"));
					setUsuario(rs.getString("usuario"));
					setSenha(rs.getString("senha"));
					setEndereco(rs.getString("endereco"));
					setTelefoneResidencial(rs.getString("telefone_residencial"));
					setTelefoneCelular(rs.getString("telefone_celular"));
					setAcessoLivre(rs.getString("acessoLivre"));
					setAutorizado(rs.getString("autorizado"));
					setTipoUsuario(rs.getString("tipoUsuario"));
					setPeriodo(rs.getString("periodo"));
				} else{
					setId(-1);
					setNome(null);
					setCpf(null);
					setUsuario(null);
					setSenha(null);
					setEndereco(null);
					setTelefoneResidencial(null);
					setTelefoneCelular(null);
					setAcessoLivre(null);
					setAutorizado(null);
					setTipoUsuario(null);
					setPeriodo(null);
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
		} catch(SQLException e1){
			System.out.println(e1.getStackTrace());
		}
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