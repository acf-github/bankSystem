package com.myfinance.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.myfinance.service.Query;

@Entity
@Table(name = "Usuario", uniqueConstraints = { @UniqueConstraint(name = "loginUnico", columnNames = {"login"}) })
public class Usuario extends AbstractEntity {
	
	public static class UsuarioQuery implements Query {

		private final String SELECT_QUERY = "select c from Usuario c ";

		private final String WHERE_QUERY = " where "
				+ "(:login is null or :login = '' or c.login = :login) "
				+ "and (:password is null or :password = '' or c.password = :password)";

		public String getQuery() {
			return SELECT_QUERY + WHERE_QUERY;
		}
		
		private String login;
		private String password;

		public Map<String, String> getParamsMap() {
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("login", getLogin());
			map.put("password", getPassword());
			
			return map;
		}

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
	}
	
	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "usuario")
	private Pessoa pessoa;
	
	private String login;
	private String password;
	private String email;
	
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
