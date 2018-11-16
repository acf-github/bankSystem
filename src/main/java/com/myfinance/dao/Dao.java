package com.myfinance.dao;

import java.util.List;

import com.myfinance.controller.Query;
import com.myfinance.domain.AbstractEntity;

public interface Dao<T extends AbstractEntity> {

	T findById(Class<T> clazz, int id);

	List<T> list(Class<T> clazz,  Query query);

	T persistOrMerge(T element);
	
	void delete(T element);

	void deleteById(Class<T> clazz, int id);
}
