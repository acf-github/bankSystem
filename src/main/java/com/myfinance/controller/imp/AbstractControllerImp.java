package com.myfinance.controller.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myfinance.controller.AbstractController;

public class AbstractControllerImp<T> implements AbstractController<T> {

	public T findById(Class<T> element, int id) {
		T retorno = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			retorno = manager.find(element, id);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

	public List<T> list() {

		return null;
	}

	public T persistOrMerge(T element) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.persist(element);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void delete(T element) {
		// TODO Auto-generated method stub

	}

}
