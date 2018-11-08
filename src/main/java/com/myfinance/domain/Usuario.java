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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	

}
