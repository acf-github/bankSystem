package com.myfinance.domain;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myfinance.service.ContaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/applicationContext.xml" })
public class ContaTestJunit {

	@Autowired
	public ApplicationContext context;

	@Autowired
	public ContaService contaService;

	@Before
	public void init() {
		Assume.assumeTrue(true);
	}
	
	@Test
	public void depositarComCpf () {
		
		String cpf = "05476722416";
		double valor = 100;
		
		try {
			contaService.depositarUsingCpf(cpf, valor);
			System.out.println("Operacao realizada com sucesso!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void depositarComConta () {
		
		
		int agencia = 3455;
		int conta = 564764;
		
		double valor = 150;
		
		try {
			contaService.depositarUsingConta(agencia, conta, valor);
			System.out.println("Operacao realizada com sucesso!");
			
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
