package com.myfinance.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.myfinance.domain.AbstractEntity;
import com.myfinance.service.Dao;
import com.myfinance.service.Query;

@Service
public class DaoImp<T extends AbstractEntity> implements Dao<T> {
	
	@PersistenceContext(unitName = "myFinance")
	private EntityManager manager;

	public T findById(Class<T> clazz, int id) {
		T retorno = null;
		try {
			retorno = manager.find(clazz, id);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao procurar o elemento {" + e.getMessage() + "}!");
		}
		return retorno;
	}

	public List<T> list(Class<T> clazz, Query query) {
		List<T> retorno = new ArrayList<T>();

		try {

			TypedQuery<T> queryParametrizada = manager.createQuery(query.getQuery(), clazz);

			if (query.getParamsMap() != null && !query.getParamsMap().isEmpty()) {
				for (Entry<String, String> entrySet : query.getParamsMap().entrySet()) {
					queryParametrizada.setParameter(entrySet.getKey(), entrySet.getValue());
				}
			}

			retorno = queryParametrizada.getResultList();

		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao Listar os elementos {" + e.getMessage() + "}!");
		}

		return retorno;
	}

	public T persistOrMerge(T element) {
		try {

			if (element.isNew()) {
				manager.persist(element);
			} else {
				manager.merge(element);
			}
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
			T find = (T) manager.getReference(element.getClass(), element.getId());
			manager.remove(find);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao deletar o elemento {" + e.getMessage() + "}!");
		}
	}

	public void deleteById(Class<T> clazz, int id) {
		try {
			T find = manager.find(clazz, id);
			manager.remove(find);
		} catch (Exception e) {
			throw new RuntimeException("Ocorreu um erro ao deletar o elemento {" + e.getMessage() + "}!");
		}
	}

}
