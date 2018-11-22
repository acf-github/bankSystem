package com.myfinance.service.imp;

import org.springframework.stereotype.Service;

import com.myfinance.domain.Pessoa;
import com.myfinance.service.ClienteService;
import com.myfinance.utils.StringUtils;

@Service
public class ClienteServiceImp extends AbstractServiceImp<Pessoa> implements ClienteService{

	@Override
	public Pessoa persistOrMerge(Pessoa cliente) {
		if (!StringUtils.validarCPF(cliente.getDadosPessoais().getCpf())) {
			throw new RuntimeException("CPF digitado nao e valido");
		}
		
		return super.persistOrMerge(cliente);
	}
	
	@Override
	protected
	Class<Pessoa> getEntityClass() {
		return Pessoa.class;
	}
	

	
}
