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

import com.myfinance.controller.ClienteController;
import com.myfinance.controller.GerenteController;
import com.myfinance.controller.imp.ClienteControllerImpl;
import com.myfinance.controller.imp.GerenteControllerImpl;
import com.myfinance.domain.Cliente.ClienteQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/applicationContext.xml" })
public class ClienteTestJunit {

	@Autowired
	public ApplicationContext context;

	@Before
	public void init() {
		Assume.assumeTrue(true);
	}

	@Test
	public void listCliente() {

		ClienteQuery clienteQuery = new ClienteQuery();
		// clienteQuery.setCpf("345345345");

		ClienteController controller = new ClienteControllerImpl();
		List<Cliente> retono = controller.list(Cliente.class, clienteQuery);
		for (Cliente cliente : retono) {
			System.out.println(cliente.getPessoa().getNome() + " - " + cliente.getPessoa().getCpf());
		}
	}

	@Test
	public void removeCliente() {

		try {
			ClienteController controller = new ClienteControllerImpl();
			Cliente cliente = controller.findById(Cliente.class, 1);

			System.out.println("Removendo Cliente de id = " + cliente.getId());

			controller.delete(cliente);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void removeClienteById() {

		int id = 1;
		try {

			ClienteController controller = new ClienteControllerImpl();
			controller.deleteById(Cliente.class, id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void findClienteById() {

		try {
			ClienteController controller = new ClienteControllerImpl();
			Cliente cliente = controller.findById(Cliente.class, 1);
			System.out.println(cliente.getPessoa().getNome());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void createCliente() {
		Pessoa pessoa = new Pessoa();

		pessoa.setCpf("01726533476");
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
		conta.setAgencia(3455);
		conta.setCodigoBanco(341);
		conta.setDigitoAgencia(2);
		conta.setDigitoContaCorrente(1);
		conta.setContaCorrente(564764);
		conta.setSaldo(100);

		Cliente cliente = new Cliente();
		cliente.setPessoa(pessoa);
		cliente.setConta(conta);

		// ClienteController controller = new ClienteControllerImpl();
		// controller.persistOrMerge(cliente);
		try {
			ClienteController controller = new ClienteControllerImpl();
			controller.persistOrMerge(cliente);
			System.out.println("operacao realizada com sucesso!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	

	@Test
	public void cadastrarCliente() {
		
		Pessoa pessoa = new Pessoa();

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

		Cliente cliente = new Cliente();
		cliente.setPessoa(pessoa);
		cliente.setConta(conta);

		// ClienteController controller = new ClienteControllerImpl();
		// controller.persistOrMerge(cliente);
		try {
			GerenteController controller = new GerenteControllerImpl();
			controller.criarCliente(cliente);
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
