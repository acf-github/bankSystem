package com.myfinance.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedValue
	private int id;
	
	@Version
	private Integer version;
	
	private Date dataCadastramento;
	
	public AbstractEntity() {
		super();
		this.dataCadastramento = new Date();
	}

	public int getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

}
