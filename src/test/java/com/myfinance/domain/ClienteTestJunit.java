package com.myfinance.domain;

import java.util.List;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myfinance.domain.Pessoa.PessoaQuery;
import com.myfinance.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/applicationContext.xml" })
public class ClienteTestJunit {

	@Autowired
	public ApplicationContext context;
	
	@Autowired
	public ClienteService clienteController;

	@Before
	public void init() {
		Assume.assumeTrue(true);
	}
	
	@Test
	public void editarCliente() {
		
		Pessoa cliente  = clienteController.findById(Pessoa.class, 1);
		cliente.getDadosPessoais().setNome("novo nome teste");
		
		clienteController.persistOrMerge(cliente);
	}

	@Test
	public void listCliente() {

		PessoaQuery clienteQuery = new PessoaQuery();
		// clienteQuery.setCpf("345345345");

		List<Pessoa> retono = clienteController.list(Pessoa.class, clienteQuery);
		for (Pessoa cliente : retono) {
			System.out.println(cliente.getDadosPessoais().getNome() + " - " + cliente.getDadosPessoais().getCpf());
		}
	}

	@Test
	public void removeCliente() {

		try {
			Pessoa cliente = clienteController.findById(Pessoa.class, 1);

			System.out.println("Removendo Cliente de id = " + cliente.getId());

			clienteController.delete(cliente);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void removeClienteById() {

		int id = 1;
		try {

			clienteController.deleteById(Pessoa.class, id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void findClienteById() {

		try {
			Pessoa cliente = clienteController.findById(Pessoa.class, 1);
			System.out.println(cliente.getDadosPessoais().getNome());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void createCliente() {
		DadosPessoais dadosPessoais = new DadosPessoais();

		dadosPessoais.setCpf("01726533476");
		dadosPessoais.setIdade(15);
		dadosPessoais.setNome("teste de nome");
		dadosPessoais.setSobreNome("teste sobrenome");
		dadosPessoais.setRg("21545");

		dadosPessoais.setCpf("05476722416");
		dadosPessoais.setIdade(123);
		dadosPessoais.setNome("testee de nome");
		dadosPessoais.setSobreNome("testee sobrenome");
		dadosPessoais.setRg("215145");

		dadosPessoais.getEndereco().setCep("50650040");
		dadosPessoais.getEndereco().setComplemento("complemento");
		dadosPessoais.getEndereco().setMunicipio("recife");
		dadosPessoais.getEndereco().setPais("brasil");
		dadosPessoais.getEndereco().setRua("rua");

		Conta conta = new Conta();
		conta.setAgencia(3455);
		conta.setCodigoBanco(341);
		conta.setDigitoAgencia(2);
		conta.setDigitoContaCorrente(1);
		conta.setContaCorrente(564764);
		conta.setSaldo(100);

		Pessoa cliente = new Pessoa();
		cliente.setDadosPessoais(dadosPessoais);
		cliente.setConta(conta);

		// ClienteController controller = new ClienteControllerImpl();
		// controller.persistOrMerge(cliente);
		try {
			clienteController.persistOrMerge(cliente);
			System.out.println("operacao realizada com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	

	@Test
	public void cadastrarCliente() {
		
		DadosPessoais pessoa = new DadosPessoais();

		pessoa.setCpf("97675217047");
		pessoa.setIdade(15);
		pessoa.setNome("teste de nome");
		pessoa.setSobreNome("teste sobrenome");
		pessoa.setRg("21545");

		pessoa.setCpf("05476722416");
		pessoa.setIdade(123);
		pessoa.setNome("testee de nome");
		pessoa.setSobreNome("testee sobrenome");
		pessoa.setRg("215145");

		pessoa.getEndereco().setCep("50650040");
		pessoa.getEndereco().setComplemento("complemento");
		pessoa.getEndereco().setMunicipio("recife");
		pessoa.getEndereco().setPais("brasil");
		pessoa.getEndereco().setRua("rua");

		Conta conta = new Conta();
		conta.setAgencia(34534);
		conta.setCodigoBanco(341);
		conta.setDigitoAgencia(2);
		conta.setDigitoContaCorrente(1);
		conta.setContaCorrente(678645);
		conta.setSaldo(100);

		Pessoa cliente = new Pessoa();
		cliente.setDadosPessoais(pessoa);
		cliente.setConta(conta);
		
		Usuario usuario = new  Usuario();
		usuario.setLogin("root");
		usuario.setPassword("teste12345");
		
		cliente.setUsuario(usuario);

		try {
			clienteController.persistOrMerge(cliente);
			System.out.println("operacao realizada com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
