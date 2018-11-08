package com.myfinance.test;

import com.myfinance.controller.ClienteController;
import com.myfinance.controller.imp.ClienteControllerImpl;
import com.myfinance.domain.Cliente;
import com.myfinance.domain.Conta;
import com.myfinance.domain.Pessoa;



public class ClienteTest {
	
	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("01726533476");
		pessoa.setIdade(12);
		pessoa.setNome("teste de nome");
		pessoa.setSobreNome("teste sobrenome");
		pessoa.setRg("21545");
		
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
		
		ClienteController controller = new ClienteControllerImpl();
		controller.persistOrMerge(cliente);
	}

}
