package com.myfinance.controller;

import org.springframework.stereotype.Service;

import com.myfinance.controller.imp.AbstractControllerImp;
import com.myfinance.domain.Cliente;
import com.myfinance.utils.StringUtils;

@Service
public class ClienteControllerImpl extends AbstractControllerImp<Cliente> implements ClienteController{

	@Override
	public Cliente persistOrMerge(Cliente cliente) {
		if (!StringUtils.validarCPF(cliente.getPessoa().getCpf())) {
			throw new RuntimeException("CPF digitado nao e valido");
		}
		return super.persistOrMerge(cliente);
	}
	
	@Override
	protected
	Class<Cliente> getEntityClass() {
		return Cliente.class;
	}
	

	
}
