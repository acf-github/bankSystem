package com.myfinance.domain;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myfinance.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/applicationContext.xml" })
public class UsuarioTestJunit {

	@Autowired
	public ApplicationContext context;
	
	@Autowired
	public UsuarioService usuarioService;

	@Before
	public void init() {
		Assume.assumeTrue(true);
	}
	
	@Test
	public void findClienteById() {

		try {
			Usuario cliente = usuarioService.findById(Usuario.class, 1);
			System.out.println(cliente.getLogin());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void logar() {
		try {
			usuarioService.acessar("root", "teste12345");
			System.out.println("acessou");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void createUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("root");
		usuario.setPassword("teste12345");
		usuario.setPessoa(null);
		
		// ClienteController controller = new ClienteControllerImpl();
		// controller.persistOrMerge(cliente);
		try {
			usuarioService.persistOrMerge(null);
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
