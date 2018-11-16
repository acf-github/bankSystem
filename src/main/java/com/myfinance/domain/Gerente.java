package com.myfinance.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Gerente extends AbstractEntity {

	@Embedded
	private Pessoa pessoa;
	
	@Transient
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private int matricula;
	
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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	

}