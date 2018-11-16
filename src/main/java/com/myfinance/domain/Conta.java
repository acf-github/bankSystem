package com.myfinance.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Conta", uniqueConstraints = {
		@UniqueConstraint(name = "ContaUnica", columnNames = { "agencia", "contaCorrente", "codigoBanco" }) })
public class Conta extends AbstractEntity {

	@Column(nullable=false)
	private int agencia;
	private int digitoAgencia;
	@Column(nullable=false)
	private int contaCorrente;
	private int digitoContaCorrente;
	@Column(nullable=false)
	private int codigoBanco;
	private double saldo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "produto_id")
	private List<Produto> produtoList;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "favorecido_id")
	private Set<Favorecido> favorecidoSet;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "conta")
	private Cliente cliente;

	public Conta() {
		this.favorecidoSet = new HashSet<Favorecido>();
	}

	private void addFavorecido(Favorecido favorecido) {
		if (favorecido != null) {
			this.favorecidoSet.add(favorecido);
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Favorecido> getFavorecidoSet() {
		return favorecidoSet;
	}

	public void setFavorecidoSet(Set<Favorecido> favorecidoSet) {
		this.favorecidoSet = favorecidoSet;
	}

}
