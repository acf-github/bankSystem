package com.myfinance.controller.imp;


import com.myfinance.controller.GerenteController;
import com.myfinance.domain.Cliente;
import com.myfinance.domain.Gerente;
import com.myfinance.utils.StringUtils;


public class GerenteControllerImpl extends AbstractControllerImp<Gerente>  implements GerenteController {

	public Gerente persistOrMerge(Gerente gerente) {
		if (!StringUtils.validarCPF(gerente.getPessoa().getCpf())) {
			throw new RuntimeException("CPF digitado nao e valido");
		}
		return super.persistOrMerge(gerente);
	}
	
	public void criarCliente(Cliente cliente) {
		if (cliente != null) {
			getDao().persistOrMerge(cliente);
		}
	}

	@Override
	protected	Class<Gerente> getEntityClass() {
		return Gerente.class;
	}
}
