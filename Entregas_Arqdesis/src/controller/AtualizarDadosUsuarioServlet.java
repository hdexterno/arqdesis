package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class AtualizarDadosUsuarioServlet
 */
@WebServlet("/AtualizarDadosUsuario")
public class AtualizarDadosUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarDadosUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		String pEndereco = request.getParameter("endereco");
		String pTelefoneResidencial = request.getParameter("telefoneResidencial");
		String pTelefoneCelular = request.getParameter("telefoneCelular");
		String pAcessoLivre = request.getParameter("acessoLivre");
		String pAutorizado = request.getParameter("autorizado");
		String pTipoUsuario = request.getParameter("tipoUsuario");
		String pPeriodo = request.getParameter("periodo");
		Usuario usuario = new Usuario(pNome, pCpf, pUsuario, pSenha, pEndereco, pTelefoneResidencial, pTelefoneCelular, pAcessoLivre, pAutorizado, pTipoUsuario, pPeriodo);
		usuario.setId(id);
		UsuarioService service = new UsuarioService();
		service.atualizar(usuario);
		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("AlterarDadosUsuario.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
