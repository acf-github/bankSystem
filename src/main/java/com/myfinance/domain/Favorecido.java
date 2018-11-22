package com.myfinance.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Favorecido")
public class Favorecido extends AbstractEntity {

	@Embedded
	private DadosPessoais pessoa;

	public DadosPessoais getPessoa() {
		return pessoa;
	}

	public void setPessoa(DadosPessoais pessoa) {
		this.pessoa = pessoa;
	}

}
