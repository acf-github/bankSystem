package com.myfinance.controller.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.myfinance.controller.AbstractController;
import com.myfinance.controller.Query;
import com.myfinance.domain.AbstractEntity;

public class AbstractControllerImp<T> implements AbstractController<T> {

	public T findById(Class<T> clazz, int id) {
		T retorno = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			retorno = manager.find(clazz, id);
			manager.getTransaction().commit();
			manager.close();
			} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

	public List<T> list(Class<T> clazz, Query query) {
		
		List<T> retorno = new ArrayList<T>();

		try {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			
			TypedQuery<T> queryParametrizada = manager.createQuery(query.getQuery(), clazz);
			
			if (query.getParamsMap() != null && !query.getParamsMap().isEmpty()) {
				for (Entry<String, String> entrySet : query.getParamsMap().entrySet()) {
					queryParametrizada.setParameter(entrySet.getKey(), entrySet.getValue());
				}
			}
			
			retorno = queryParametrizada.getResultList();
			manager.close();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return retorno;
	}

	public <T extends AbstractEntity> T persistOrMerge(T element) {
		try {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			
			if (element.isNew()) {
				manager.persist(element);
			} else {
				manager.merge(element);
			}
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	public <T extends AbstractEntity> void delete(T element) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			
			T find = (T) manager.find(element.getClass(), element.getId());
			manager.remove(manager.merge(find));
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteById(Class<T> clazz, int id) {
		try {

			T find = findById(clazz, id);
//			delete(find);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
