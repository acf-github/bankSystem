package com.myfinance.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.myfinance.service.Query;

@Entity
@Table(name = "Conta", uniqueConstraints = {
		@UniqueConstraint(name = "ContaUnica", columnNames = { "agencia", "contaCorrente", "codigoBanco" }) })
public class Conta extends AbstractEntity {

	public static class ContaQuery implements Query {

		private final String SELECT_QUERY = "select c from Conta c ";

		private final String WHERE_QUERY = " where " + "(:agencia is null or :agencia = 0 or c.agencia = :agencia) "
				+ "and (:digitoAgencia is null or :digitoAgencia = 0 or c.digitoAgencia = :digitoAgencia)"
				+ "and (:contaCorrente is null or :contaCorrente = 0 or c.contaCorrente = :contaCorrente)"
				+ "and (:digitoContaCorrente is null or :digitoContaCorrente = 0 or c.digitoContaCorrente = :digitoContaCorrente)"
				+ "and (:codigoBanco is null or :codigoBanco = 0 or c.codigoBanco = :codigoBanco)";

		public String getQuery() {
			return SELECT_QUERY + WHERE_QUERY;
		}

		private Integer agencia;
		private Integer digitoAgencia;
		private Integer contaCorrente;
		private Integer digitoContaCorrente;
		private Integer codigoBanco;

		public Map<String, Object> getParamsMap() {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("agencia", getAgencia());
			map.put("digitoAgencia", getDigitoAgencia());
			map.put("contaCorrente", getContaCorrente());
			map.put("digitoContaCorrente", getDigitoContaCorrente());
			map.put("codigoBanco", getCodigoBanco());

			return map;
		}

		public Integer getAgencia() {
			return agencia;
		}

		public void setAgencia(Integer agencia) {
			this.agencia = agencia;
		}

		public Integer getDigitoAgencia() {
			return digitoAgencia;
		}

		public void setDigitoAgencia(Integer digitoAgencia) {
			this.digitoAgencia = digitoAgencia;
		}

		public Integer getContaCorrente() {
			return contaCorrente;
		}

		public void setContaCorrente(Integer contaCorrente) {
			this.contaCorrente = contaCorrente;
		}

		public Integer getDigitoContaCorrente() {
			return digitoContaCorrente;
		}

		public void setDigitoContaCorrente(Integer digitoContaCorrente) {
			this.digitoContaCorrente = digitoContaCorrente;
		}

		public Integer getCodigoBanco() {
			return codigoBanco;
		}

		public void setCodigoBanco(Integer codigoBanco) {
			this.codigoBanco = codigoBanco;
		}

	}

	@Column(nullable = false)
	private int agencia;
	private int digitoAgencia;
	@Column(nullable = false)
	private int contaCorrente;
	private int digitoContaCorrente;
	@Column(nullable = false)
	private int codigoBanco;
	private double saldo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "produto_id")
	private List<Produto> produtoList;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "favorecido_id")
	private Set<Favorecido> favorecidoSet;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "conta")
	private Pessoa pessoa;

	public Conta() {
		this.favorecidoSet = new HashSet<Favorecido>();
	}

	private void addFavorecido(Favorecido favorecido) {
		if (favorecido != null) {
			this.favorecidoSet.add(favorecido);
		}
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo = getSaldo() + valor;
		}
	}

	public Favorecido getOrCreateFavorecido(Favorecido favorecido) {
		Favorecido retorno = favorecido;

		if (this.favorecidoSet == null || this.favorecidoSet.isEmpty()) {
			addFavorecido(favorecido);
		} else {
			for (Favorecido temp : favorecidoSet) {
				if (temp.getPessoa().getCpf().equals(favorecido.getPessoa().getCpf())) {
					retorno = temp;
				}
			}
		}
		return retorno;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(int digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}

	public int getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(int contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public int getDigitoContaCorrente() {
		return digitoContaCorrente;
	}

	public void setDigitoContaCorrente(int digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}

	public int getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(int codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public Set<Favorecido> getFavorecidoSet() {
		return favorecidoSet;
	}

	public void setFavorecidoSet(Set<Favorecido> favorecidoSet) {
		this.favorecidoSet = favorecidoSet;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
