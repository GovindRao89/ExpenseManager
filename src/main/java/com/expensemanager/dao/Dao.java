package com.expensemanager.dao;

public interface Dao<K, E> {

	void persist(E entity);

	void remove(E entity);

	E findById(K id);
}
