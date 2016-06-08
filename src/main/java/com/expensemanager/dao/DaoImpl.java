package com.expensemanager.dao;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import com.expensemanager.utils.JpaUtil;


public abstract class DaoImpl<K, E> implements Dao<K, E> {
	protected Class<E> entityClass;

	protected EntityManager entityManager = JpaUtil.getEm();

	@SuppressWarnings("unchecked")
	public DaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();

		/**
		 * Returns an array of {@code Type} objects representing the actual type
		 * arguments to this type.
		 *
		 * <p>
		 * Note that in some cases, the returned array be empty. This can occur
		 * if this type represents a non-parameterized type nested within a
		 * parameterized type.
		 *
		 * @return an array of {@code Type} objects representing the actual type
		 *         arguments to this type
		 * @throws TypeNotPresentException
		 *             if any of the actual type arguments refers to a
		 *             non-existent type declaration
		 * @throws MalformedParameterizedTypeException
		 *             if any of the actual type parameters refer to a
		 *             parameterized type that cannot be instantiated for any
		 *             reason
		 * @since 1.5
		 */
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	public void persist(E entity) {
		entityManager.persist(entity);
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}
	
	public void refresh(E entity) {
		entityManager.refresh(entity);
	}
	
	public void merge(E entity) {
		entityManager.merge(entity);
	}

	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

	public void beginTransaction() {
		if(!entityManager.getTransaction().isActive())
		entityManager.getTransaction().begin();
	}

	public void commitTransection() {
		entityManager.getTransaction().commit();
	}

	public void close() {
		entityManager.close();
	}
}
