package com.myfinance.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Conta {
	
	private int agencia;
	private int conta;
	private int digitoAgencia;
	private int codigoBanco;
	private double saldo;
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getDigitoAgencia() {
		return digitoAgencia;
	}
	public void setDigitoAgencia(int digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
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
	
	/// colocar método consultarSaldo()
	// colocar método gerarExtrato()
}


