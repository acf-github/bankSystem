package com.myfinance.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myfinance.domain.Usuario;
import com.myfinance.domain.Usuario.UsuarioQuery;
import com.myfinance.service.UsuarioService;
import com.myfinance.utils.StringUtils;

@Service
public class UsuarioServiceImp extends AbstractServiceImp<Usuario> implements UsuarioService {

	public Usuario acessar(String login, String password) {

		if (StringUtils.isNullOrEmpty(login) || StringUtils.isNullOrEmpty(password)) {
			throw new RuntimeException("O campo login e/ou senha tem que ser preenchido");
		}

		UsuarioQuery query = new UsuarioQuery();
		query.setLogin(login);
		query.setPassword(password);
		List<Usuario> usuarioList = getDao().list(Usuario.class, query);
		if (usuarioList.isEmpty()) {
			throw new RuntimeException("Login ou senha Invalido!");
		}
		return usuarioList.get(0);
	}

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}
	
}
