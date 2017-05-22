package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	Usuario usuario, copia;
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
		usuario = new Usuario(id, "Rayza Silva", "88381952263", "rs883", "1234", "Rua das Amoras", "11 988256786", "11 28908736", "1", "1", "1", "t");
		copia = new Usuario(id, "Rayza Silva", "88381952263", "rs883", "1234", "Rua das Amoras", "11 988256786", "11 28908736", "1", "1", "1", "t");
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//Para funcionar, o cliente 1 deve ter sido carregado no banco por fora
		Usuario fixture = new Usuario(1, "Fernanda Chaves", "35641078520", "35641078520", "fer356", "Rua dos Virginianos, 09", "11 24578910", "11 975410236", "1", "1", "2", "n");
		Usuario novo = new Usuario(1, null, null, null, null, null, null, null, null, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		usuario.criar();
		id = usuario.getId();
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		usuario.setTelefoneCelular("11 99999999");
		copia.setTelefoneCelular("11 99999999");
		usuario.atualizar();
		usuario.carregar();
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
		usuario.excluir();
		usuario.carregar();
		assertEquals("testa exclusao", usuario, copia);
	}
}