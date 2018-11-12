package com.myfinance.test;

import com.myfinance.controller.GerenteController;
import com.myfinance.controller.imp.GerenteControllerImpl;
import com.myfinance.domain.Gerente;
import com.myfinance.domain.Pessoa;
import javax.persistence.Persistence;


public class GerenteTest {
	
	public static void createGerente( ) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("05476722416");
		pessoa.setIdade(15);
		pessoa.setNome("Camilo");
		pessoa.setSobreNome("Uchôa");
		pessoa.setRg("21545");
		pessoa.setIdade(15);
		pessoa.setNome("teste de nome");
		pessoa.setSobreNome("teste sobrenome");
		pessoa.setRg("21545");
		
		Gerente gerente = new Gerente();
		gerente.setPessoa(pessoa);
		
		try {
			GerenteController controller = new GerenteControllerImpl();
			controller.persistOrMerge(gerente)
			
		}
	}

}
