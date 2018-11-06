package com.myfinance.controller.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myfinance.controller.ClienteController;
import com.myfinance.domain.Cliente;

public class ClienteControllerImpl implements ClienteController {

	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente persistOrMerge(Cliente element) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(element);
		manager.getTransaction().commit();
		
		return element;
	}

	public void delete(Cliente element) {
		
	}

	
}
