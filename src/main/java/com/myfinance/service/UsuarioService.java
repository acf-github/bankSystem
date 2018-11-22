package com.myfinance.service;

import com.myfinance.domain.Usuario;

public interface UsuarioService extends AbstractService<Usuario> {

	
	Usuario acessar(String login, String password);
	
}
