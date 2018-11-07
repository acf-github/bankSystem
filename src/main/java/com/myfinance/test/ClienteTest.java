package com.myfinance.test;

import com.myfinance.controller.ClienteController;
import com.myfinance.controller.imp.ClienteControllerImpl;
import com.myfinance.domain.Cliente;



public class ClienteTest {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("teste");
		cliente.setSobreNome("sobrenome");
		
		ClienteController controller = new ClienteControllerImpl();
		controller.persistOrMerge(cliente);
	}

}
