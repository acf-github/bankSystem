package com.myfinance.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.myfinance.service.Query;

@Entity
@Table(name = "Pessoa", uniqueConstraints = {
		@UniqueConstraint(name = "pessoaUnica", columnNames = { "cpf", "tipoPessoa" }) })
public class Pessoa extends AbstractEntity {

	public static class PessoaQuery implements Query {

		private final String SELECT_QUERY = "select p from Pessoa p ";

		private final String WHERE_QUERY = " where "
				+ "(:cpf is null or :cpf = '' or p.dadosPessoais.cpf = :cpf) "
				+ "and (:nome is null or :nome = '' or p.dadosPessoais.nome = :nome)";

		public String getQuery() {
			return SELECT_QUERY + WHERE_QUERY;
		}
		
		private String cpf;
		private String nome;

		public Map<String, Object> getParamsMap() {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("cpf", getCpf());
			map.put("nome", getNome());
			
			return map;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	}
	
	public enum TipoPessoa {
		CLIENTE, GERENTE
	}

	@Embedded
	private DadosPessoais dadosPessoais;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Usuario usuario;
 
	public Pessoa() {
	}
	
	public Pessoa(DadosPessoais dadosPessoais, Conta conta) {
		this.dadosPessoais = dadosPessoais;
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
