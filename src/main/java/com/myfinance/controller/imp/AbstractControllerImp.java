package com.myfinance.controller.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.myfinance.controller.AbstractController;
import com.myfinance.controller.Query;
import com.myfinance.dao.Dao;
import com.myfinance.domain.AbstractEntity;

public class AbstractControllerImp<T extends AbstractEntity> implements AbstractController<T> {
	
	private Dao dao;
	
	public AbstractControllerImp(){
		dao = new DaoImp<T>();
	}
	
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

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
