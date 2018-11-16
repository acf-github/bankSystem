package com.myfinance.domain;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.myfinance.utils.DateUtils;

@Entity
@Table(name="Produto")
public class Produto extends AbstractEntity {

	public enum TipoProduto {
		CARTAO, CHEQUE_ESPECIAL
	}

	@Enumerated(EnumType.STRING)
	private TipoProduto tipoProduto;
	
	private double limiteUsado;
	private double limiteDisponivel;
	private Date dataInicioUso;
	private double valorMultaUsoPorDia;
	
	@Embedded
	private Cartao cartao;

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private Conta conta;
	

	public double calcularMultaUso(Date dataFechamento) {

		double valorDesconto = 0;

		if (dataInicioUso != null) {
			int qtdDias = DateUtils.calcularDiasEntre(dataInicioUso, dataFechamento);
			valorDesconto = qtdDias * valorMultaUsoPorDia;
			dataInicioUso = null;
		}
		return valorDesconto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public double getLimiteUsado() {
		return limiteUsado;
	}

	public void setLimiteUsado(double limiteUsado) {
		this.limiteUsado = limiteUsado;
	}

	public double getLimiteDisponivel() {
		return limiteDisponivel;
	}

	public void setLimiteDisponivel(double limiteDisponivel) {
		this.limiteDisponivel = limiteDisponivel;
	}

	public Date getDataInicioUso() {
		return dataInicioUso;
	}

	public void setDataInicioUso(Date dataInicioUso) {
		this.dataInicioUso = dataInicioUso;
	}

	public double getValorMultaUsoPorDia() {
		return valorMultaUsoPorDia;
	}

	public void setValorMultaUsoPorDia(double valorMultaUsoPorDia) {
		this.valorMultaUsoPorDia = valorMultaUsoPorDia;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
