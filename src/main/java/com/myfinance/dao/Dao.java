package com.myfinance.dao;

import java.util.List;

public interface Dao<T> {

	T findById(int id);

	List<T> list();

	T PersistOrMerge(T element);
	
	void delete(T element);
}
