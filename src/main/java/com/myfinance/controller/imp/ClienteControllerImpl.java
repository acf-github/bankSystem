package com.myfinance.controller.imp;

import com.myfinance.controller.ClienteController;
import com.myfinance.domain.Cliente;
import com.myfinance.utils.StringUtils;

public class ClienteControllerImpl extends AbstractControllerImp<Cliente> implements ClienteController {

	@Override
	public Cliente persistOrMerge(Cliente cliente) {
		if (!StringUtils.validarCPF(cliente.getPessoa().getCpf())) {
			throw new RuntimeException("CPF digitado nao e valido");
		}
		return super.persistOrMerge(cliente);
	}

}
