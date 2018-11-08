package com.myfinance.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity {

	@OneToOne(cascade = CascadeType.PERSIST)
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Conta conta;
	
	public Cliente() {}
	
	public Cliente(Pessoa pessoa, Conta conta) {
		this.pessoa = pessoa;
		this.conta = conta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
