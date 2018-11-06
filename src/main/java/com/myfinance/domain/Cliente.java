package com.myfinance.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Cliente")
public class Cliente extends AbstractEntity {
	

	private String nome;
	private String sobreNome;
	
	
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
