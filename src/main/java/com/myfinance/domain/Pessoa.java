package com.myfinance.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Pessoa {

	@Column(nullable=false) 
	private String nome;
	private String sobreNome;
	@Column(nullable=false) 
	private String cpf;
	@Column(nullable=false) 
	private String rg;
	@Column(nullable=false) 
	private int idade;

	@Column(nullable=false) 
	private Endereco endereco;
	
	public Pessoa() {
		this.endereco = new Endereco();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
}
