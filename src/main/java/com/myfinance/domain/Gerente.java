package com.myfinance.domain;

import javax.persistence.Entity;

@Entity
public class Gerente extends AbstractEntity {

	private Pessoa pessoa;
	
	public Gerente() {}

	public Gerente(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

}
