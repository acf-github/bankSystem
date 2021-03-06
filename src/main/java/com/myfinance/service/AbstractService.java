package com.myfinance.service;

import java.util.List;

import com.myfinance.domain.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {
	
	T findById(Class<T> clazz, int id);

	List<T> list(Class<T> clazz,  Query query);

	T persistOrMerge(T element);
	
	void delete(T element);

	void deleteById(Class<T> clazz, int id);
	
}
