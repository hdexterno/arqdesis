package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Usuario;
import service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	Usuario usuario, copia;
	UsuarioService usuarioService;
	static int id = 0;
	
	/*
	 * Antes de rodar este teste, certifique-se que não há no banco nenhuma
	 * linha com o ID igual ao do escolhido para o TO instanciado abaixo.
	 * Se houver, delete.
	 * Certifique-se também que sobrecarregou o equals na classe Usuario.
	 * Certifique-se que a fixture Usuario foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante;
	 * por isso a anotação FixMethodOrder logo acima do nome desta classe.
	 */
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome("Rayza Silva");
		usuario.setCpf("88381952263");
		usuario.setUsuario("rs883");
		usuario.setSenha("1234");
		usuario.setEndereco("Rua das Amoras, 88");
		usuario.setTelefoneResidencial("11 28908736");
		usuario.setTelefoneCelular("11 988256786");
		usuario.setAcessoLivre("1");
		usuario.setAutorizado("1");
		usuario.setTipoUsuario("1");
		usuario.setPeriodo("t");
		copia = new Usuario();
		copia.setId(id);
		copia.setNome("Rayza Silva");
		copia.setCpf("88381952263");
		copia.setUsuario("rs883");
		copia.setSenha("1234");
		copia.setEndereco("Rua das Amoras, 88");
		copia.setTelefoneResidencial("11 28908736");
		copia.setTelefoneCelular("11 988256786");
		copia.setAcessoLivre("1");
		copia.setAutorizado("1");
		copia.setTipoUsuario("1");
		copia.setPeriodo("t");
		usuarioService = new UsuarioService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//Para funcionar, o cliente 1 deve ter sido carregado no banco por fora
		Usuario fixture = new Usuario();
		fixture.setId(1);
		fixture.setNome("Fernanda Chaves");
		fixture.setCpf("35641078520");
		fixture.setUsuario("35641078520");
		fixture.setSenha("fer356");
		fixture.setEndereco("Rua dos Virginianos, 09");
		fixture.setTelefoneResidencial("11 24578910");
		fixture.setTelefoneCelular("11 975410236");
		fixture.setAcessoLivre("1");
		fixture.setAutorizado("1");
		fixture.setTipoUsuario("2");
		fixture.setPeriodo("n");
		UsuarioService novoService = new UsuarioService();
		Usuario novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = usuarioService.criar(usuario);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		usuario.setTelefoneCelular("11 99999999");
		copia.setTelefoneCelular("11 99999999");
		usuarioService.atualizar(usuario);
		usuario = usuarioService.carregar(usuario.getId());
		assertEquals("testa atualizacao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setCpf(null);
		copia.setUsuario(null);
		copia.setSenha(null);
		copia.setEndereco(null);
		copia.setTelefoneResidencial(null);
		copia.setTelefoneCelular(null);
		copia.setAcessoLivre(null);
		copia.setAutorizado(null);
		copia.setTipoUsuario(null);
		copia.setPeriodo(null);
		usuarioService.excluir(id);
		usuario = usuarioService.carregar(id);
		assertEquals("testa exclusao", usuario, copia);
	}
}