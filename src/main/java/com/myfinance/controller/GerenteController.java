package com.myfinance.controller;

import com.myfinance.domain.Cliente;
import com.myfinance.domain.Gerente;

public interface GerenteController extends AbstractController<Gerente> {
	void criarCliente(Cliente cliente);
	
}
