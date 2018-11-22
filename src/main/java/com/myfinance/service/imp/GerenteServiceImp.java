package com.myfinance.service.imp;


import com.myfinance.domain.Pessoa;
import com.myfinance.service.GerenteService;
import com.myfinance.utils.StringUtils;


public class GerenteServiceImp extends AbstractServiceImp<Pessoa>  implements GerenteService {

	public Pessoa persistOrMerge(Pessoa gerente) {
		if (!StringUtils.validarCPF(gerente.getDadosPessoais().getCpf())) {
			throw new RuntimeException("CPF digitado nao e valido");
		}
		return super.persistOrMerge(gerente);
	}
	
	public void criarCliente(Pessoa cliente) {
		if (cliente != null) {
			getDao().persistOrMerge(cliente);
		}
	}

	@Override
	protected	Class<Pessoa> getEntityClass() {
		return Pessoa.class;
	}
}
