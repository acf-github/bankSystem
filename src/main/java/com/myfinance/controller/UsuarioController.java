package com.myfinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myfinance.domain.Usuario;
import com.myfinance.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	  private UsuarioService usuarioService;
	  
	  
//	  @RequestMapping(method = RequestMethod.GET)
//	  public @ResponseBody List findAll() {
//	    return clienteService.list(Pessoa.class, PessoaQuery query);
//	  }

	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public @ResponseBody Usuario findOne(@PathVariable String login, @PathVariable String password) {
		  return usuarioService.acessar(login, password);
	  }


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
