package service;

import java.sql.SQLException;
import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public Usuario criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	
	public Usuario atualizar(Usuario usuario){
		return dao.atualizar(usuario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}

	public List<Usuario> listarUsuarios() {
		try{
			return dao.listarUsuarios();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}