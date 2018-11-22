package com.myfinance.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myfinance.controller.AbstractController;
import com.myfinance.controller.Dao;
import com.myfinance.controller.Query;
import com.myfinance.domain.AbstractEntity;

@Transactional(rollbackFor = { Throwable.class }, value = "transactionManager")
public abstract class AbstractControllerImp<T extends AbstractEntity> implements AbstractController<T> {
	
	@Autowired
	private Dao dao;

	public T findById(Class<T> clazz, int id) {
		return (T) dao.findById(clazz, id);
	}

	public List<T> list(Class<T> clazz, Query query) {

		return dao.list(clazz, query);
	}

	public T persistOrMerge(T element) {
		return (T) dao.persistOrMerge(element);
	}

	@Transactional(readOnly = false)
	public void delete(T element) {
		dao.delete(element);
	}

	@Transactional(readOnly = false)
	public void deleteById(Class<T> clazz, int id) {
		dao.deleteById(clazz, id);
	}

	public Dao getDao() {
		return dao;
	}
	
	protected abstract <T> Class<T> getEntityClass();
}
