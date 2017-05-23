package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	public Usuario criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(nome, cpf, usuario, senha, endereco, telefone_residencial, telefone_celular, acessoLivre, autorizado, tipoUsuario, periodo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getCpf());
			stm.setString(3, usuario.getUsuario());
			stm.setString(4, usuario.getSenha());
			stm.setString(5, usuario.getEndereco());
			stm.setString(6, usuario.getTelefoneResidencial());
			stm.setString(7, usuario.getTelefoneCelular());
			stm.setString(8, usuario.getAcessoLivre());
			stm.setString(9, usuario.getAutorizado());
			stm.setString(10, usuario.getTipoUsuario());
			stm.setString(11, usuario.getPeriodo());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, usuario=?, senha=?, endereco=?, telefone_residencial=?, telefone_celular=?,"
				+ "acessoLivre=?, autorizado=?, tipoUsuario=?, periodo=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getCpf());
			stm.setString(3, usuario.getUsuario());
			stm.setString(4, usuario.getSenha());
			stm.setString(5, usuario.getEndereco());
			stm.setString(6, usuario.getTelefoneResidencial());
			stm.setString(7, usuario.getTelefoneCelular());
			stm.setString(8, usuario.getAcessoLivre());
			stm.setString(9, usuario.getAutorizado());
			stm.setString(10, usuario.getTipoUsuario());
			stm.setString(11, usuario.getPeriodo());
			stm.setInt(12, usuario.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario carregar(int id){
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT * FROM usuario WHERE usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setUsuario(rs.getString("usuario"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setTelefoneResidencial(rs.getString("telefone_residencial"));
					usuario.setTelefoneCelular(rs.getString("telefone_celular"));
					usuario.setAcessoLivre(rs.getString("acessoLivre"));
					usuario.setAutorizado(rs.getString("autorizado"));
					usuario.setTipoUsuario(rs.getString("tipoUsuario"));
					usuario.setPeriodo(rs.getString("periodo"));
				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setCpf(null);
					usuario.setUsuario(null);
					usuario.setSenha(null);
					usuario.setEndereco(null);
					usuario.setTelefoneResidencial(null);
					usuario.setTelefoneCelular(null);
					usuario.setAcessoLivre(null);
					usuario.setAutorizado(null);
					usuario.setTipoUsuario(null);
					usuario.setPeriodo(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public List<Usuario> listarUsuarios() throws SQLException {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		String sql = "SELECT * FROM USUARIO";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()){
				usuarios.add(new Usuario (rs.getInt("ID"), rs.getString("NOME"), rs.getString("CPF")));
			}
		}
		return usuarios;
	}
}