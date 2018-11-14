package com.myfinance.dao;

import java.util.List;

import com.myfinance.controller.Query;
import com.myfinance.domain.AbstractEntity;

public interface Dao<T> {

	T findById(Class<T> clazz, int id);

	List<T> list(Class<T> clazz,  Query query);

	<T extends AbstractEntity> T persistOrMerge(T element);
	
	<T extends AbstractEntity> void delete(T element);

	void deleteById(Class<T> clazz, int id);
}
