package com.myfinance.test;

import com.myfinance.controller.ClienteController;
import com.myfinance.controller.imp.ClienteControllerImpl;
import com.myfinance.domain.Cliente;
import com.myfinance.domain.Conta;
import com.myfinance.domain.Pessoa;
import javax.persistence.Persistence;

public class ClienteTest {

	public static void main(String[] args) {
		createCliente();
	}

	public static void findClienteById() {

		try {
			ClienteController controller = new ClienteControllerImpl();
			Cliente cliente = controller.findById(Cliente.class, 2);
			System.out.println(cliente.getPessoa().getId());
			System.out.println(cliente.getPessoa().getNome());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createCliente() {
		Pessoa pessoa = new Pessoa();

		pessoa.setCpf("05476722416");
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
		conta.setAgencia(7667);
		conta.setCodigoBanco(341);
		conta.setDigitoAgencia(2);
		conta.setDigitoContaCorrente(1);
		conta.setContaCorrente(213234);
		conta.setSaldo(100);

		Cliente cliente = new Cliente();
		cliente.setPessoa(pessoa);
		cliente.setConta(conta);

		
		//ClienteController controller = new ClienteControllerImpl();
		//controller.persistOrMerge(cliente);
		

		ClienteController controller = new ClienteControllerImpl();
		controller.persistOrMerge(cliente);

	 
		}
	}

