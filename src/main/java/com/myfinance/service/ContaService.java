package com.myfinance.service;

import com.myfinance.domain.Conta;

public interface ContaService extends AbstractService<Conta> {
	
	public void depositarUsingCpf(String cpf, double valor);
	
	public void depositarUsingConta(int agencia, int conta,  double valor);

}
