package com.myfinance.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Usuario", uniqueConstraints = { @UniqueConstraint(name = "loginUnico", columnNames = {"login"}) })
public class Usuario extends AbstractEntity {
	
	
	public enum TipoUsuario {
		CLIENTE, GERENTE
	}
	
	private String login;
	private String password;
	private String email;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	

}
