package com.myfinance.service;

import com.myfinance.domain.Pessoa;

public interface GerenteService extends AbstractService<Pessoa> {
	void criarCliente(Pessoa cliente);
	
}
