package com.myfinance.controller.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.myfinance.controller.AbstractController;

public class AbstractControllerImp<T> implements AbstractController<T> {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("myFinance");
	}

	public T findById(Class<T> element, int id) {
		T retorno = null;
		try {
			getEtintyManager().getTransaction().begin();
			retorno = getEtintyManager().find(element, id);
			getEtintyManager().getTransaction().commit();
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

			getEtintyManager().getTransaction().begin();
			getEtintyManager().persist(element);
			getEtintyManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void delete(T element) {
		// TODO Auto-generated method stub

	}

	public void deleteById(Class<T> element, int id) {
		// TODO Auto-generated method stub

	}

	public static EntityManager getEtintyManager() {
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}
}
