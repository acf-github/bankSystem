package com.myfinance.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myfinance.domain.AbstractEntity;
import com.myfinance.service.AbstractService;
import com.myfinance.service.Dao;
import com.myfinance.service.Query;

@Transactional(rollbackFor = { Throwable.class }, value = "transactionManager")
public abstract class AbstractServiceImp<T extends AbstractEntity> implements AbstractService<T> {
	
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
