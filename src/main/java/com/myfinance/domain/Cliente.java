package com.myfinance.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Cliente")
public class Cliente extends AbstractEntity {

	@OneToOne(cascade = CascadeType.PERSIST)
	private Pessoa pessoa;
	
	private String nome;
	private String sobreNome;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Conta conta;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
}
