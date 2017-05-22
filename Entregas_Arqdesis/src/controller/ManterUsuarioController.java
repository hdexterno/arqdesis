package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class ManterUsuarioController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		//verifica os campos selecionados em cada select
		//acesso livre
		if(pAcessoLivre.equals("não")) 		pAcessoLivre = "0";
		else if(pAcessoLivre.equals("sim")) pAcessoLivre = "1";
		//autorizado
		if(pAutorizado.equals("não")) 	   pAutorizado = "0";
		else if(pAutorizado.equals("sim")) pAutorizado = "1";
		//tipo de usuario
		if(pTipoUsuario.equals("1"))	  pTipoUsuario = "1";
		else if(pTipoUsuario.equals("2")) pTipoUsuario = "2";
		else if(pTipoUsuario.equals("3")) pTipoUsuario = "3";
		//periodo
		if(pPeriodo.equals("m"))	  pPeriodo = "m";
		else if(pPeriodo.equals("t")) pPeriodo = "t";
		else if(pPeriodo.equals("n")) pPeriodo = "n";
		
		//instanciar o javabean
		Usuario usuario = new Usuario();
		usuario.setNome(pNome);
		usuario.setCpf(pCpf);
		usuario.setUsuario(pUsuario);
		usuario.setSenha(pSenha);
		usuario.setEndereco(pEndereco);
		usuario.setTelefoneResidencial(pTelefoneResidencial);
		usuario.setTelefoneCelular(pTelefoneCelular);
		usuario.setAcessoLivre(pAcessoLivre);
		usuario.setAutorizado(pAutorizado);
		usuario.setTipoUsuario(pTipoUsuario);
		usuario.setPeriodo(pPeriodo);
		
		//instanciar o service
		UsuarioService us = new UsuarioService();
		us.criar(usuario);
		usuario = us.carregar(usuario.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body><br/><br/>");
		out.println(	"id: "+usuario.getId()+"<br>");
		out.println(	"nome: "+usuario.getNome()+"<br>");
		out.println(	"cpf: "+usuario.getCpf()+"<br>");
		out.println(	"usuario: "+usuario.getUsuario()+"<br>");
		out.println(	"senha: "+usuario.getSenha()+"<br>");
		out.println(	"endereco: "+usuario.getEndereco()+"<br>");
		out.println(	"telefone residencial: "+usuario.getTelefoneResidencial()+"<br>");
		out.println(	"telefone celular: "+usuario.getTelefoneCelular()+"<br>");
		out.println(	"acesso livre: "+usuario.getAcessoLivre()+"<br>");
		out.println(	"autorizado: "+usuario.getisAutorizado()+"<br>");
		out.println(	"tipo usuario: "+usuario.getTipoUsuario()+"<br>");
		out.println(	"periodo: "+usuario.getPeriodo()+"<br>");
	    out.println("</body></html>");
	}
}