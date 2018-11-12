package com.myfinance.dao;

import java.util.List;

public interface Dao<T> {

	T findById(Class<T> element, int id);

	List<T> list();

	T persistOrMerge(T element);
	
	void delete(T element);

	void deleteById(Class<T> element, int id);
}
