package com.myfinance.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class Conta extends AbstractEntity {

	private int agencia;
	private int digitoAgencia;
	private int contaCorrente;
	private int digitoContaCorrente;
	private int codigoBanco;
	private double saldo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "produto_id")
	private List<Produto> produtoList;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "favorecido_id")
	private Set<Pessoa> favorecidoList;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "conta")
	private Cliente cliente;

	public Conta() {
		this.favorecidoList = new HashSet<Pessoa>();
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

	public Set<Pessoa> getFavorecidoList() {
		return favorecidoList;
	}

	public void setFavorecidoList(Set<Pessoa> favorecidoList) {
		this.favorecidoList = favorecidoList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
