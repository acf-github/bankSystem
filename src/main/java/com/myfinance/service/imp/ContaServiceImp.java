package com.myfinance.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myfinance.domain.Conta;
import com.myfinance.domain.Conta.ContaQuery;
import com.myfinance.domain.Pessoa;
import com.myfinance.domain.Pessoa.PessoaQuery;
import com.myfinance.service.ContaService;

@Service
public class ContaServiceImp extends AbstractServiceImp<Conta> implements ContaService {

	@Override
	public void depositarUsingCpf(String cpf, double valor) {
		
		PessoaQuery query = new PessoaQuery();
		query.setCpf(cpf);
		
		List<Pessoa> pessoaList = getDao().list(Pessoa.class, query);
		if (pessoaList.isEmpty()) {
			throw new RuntimeException("Pessoa soliticada nao encontrada");
		}
		
		if (pessoaList.get(0).getConta() == null) {
			throw new RuntimeException("Pessoa soliticada nao tem conta configurada");
		}
		
		pessoaList.get(0).getConta().depositar(valor);
		getDao().persistOrMerge(pessoaList.get(0));
		
	}

	@Override
	public void depositarUsingConta(int agencia, int conta,  double valor) {
		
		ContaQuery query = new ContaQuery();
		query.setAgencia(agencia);
		query.setContaCorrente(conta);
		
		List<Conta> contaList = getDao().list(Conta.class, query);
		if (contaList.isEmpty()) {
			throw new RuntimeException("Conta soliticada nao encontrada");
		}
		
		contaList.get(0).depositar(valor);
		getDao().persistOrMerge(contaList.get(0));
	}

	@Override
	protected Class<Conta> getEntityClass() {
		return Conta.class;
	}

}
