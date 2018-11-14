package com.myfinance.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.myfinance.controller.Query;

@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity {

	public static class ClienteQuery implements Query {

		private final String SELECT_QUERY = "select c from Cliente c ";

		private final String WHERE_QUERY = " where "
				+ "(:cpf is null or :cpf = '' or c.pessoa.cpf = :cpf) "
				+ "and (:nome is null or :nome = '' or c.pessoa.nome = :nome)";

		public String getQuery() {
			return SELECT_QUERY + WHERE_QUERY;
		}
		
		private String cpf;
		private String nome;

		public Map<String, String> getParamsMap() {
			
			Map<String, String> map = new HashMap<String, String>();
			
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

	@OneToOne(cascade = CascadeType.PERSIST)
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Conta conta;

	@Transient
	private Usuario usuario;

	public Cliente() {
	}

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
