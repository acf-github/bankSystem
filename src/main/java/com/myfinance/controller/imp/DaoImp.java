package com.myfinance.controller.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.myfinance.controller.Query;
import com.myfinance.dao.Dao;
import com.myfinance.domain.AbstractEntity;

public class DaoImp<T extends AbstractEntity> implements Dao<T> {

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
			throw new RuntimeException("Ocorreu um erro ao procurar o elemento {" + e.getMessage() + "}!");
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
			throw new RuntimeException("Ocorreu um erro ao Listar os elementos {" + e.getMessage() + "}!");
		}

		return retorno;
	}

	public T persistOrMerge(T element) {
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
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("Ja existe um elemento no banco de dados com as mesmas caracteristicas!");
			} else {
				throw new RuntimeException("Ocorreu um erro ao salvar o elemento {" + e.getMessage() + "}!");
			}
		}
		return element;
	}

	public void delete(T element) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.remove(manager.merge(element));
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao deletar o elemento {" + e.getMessage() + "}!");
		}
	}

	public void deleteById(Class<T> clazz, int id) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			T find = manager.find(clazz, id);
			manager.remove(find);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao deletar o elemento {" + e.getMessage() + "}!");
		}
	}

}
