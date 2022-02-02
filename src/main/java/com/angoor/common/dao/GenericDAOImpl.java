/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 * Abstract implementation of {@link GenericDAO}
 * <p/>
 * By defining this class as abstract, we prevent Spring from creating instance
 * of this class. If not defined as abstract, getClass().getGenericSuperClass()
 * would return Object, and as Object class doesn't have a constructor with
 * parameters, there would be exception.
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public abstract class GenericDAOImpl<E, K extends Serializable> implements GenericDAO<E, K> {
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void addOrUpdate(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void update(E entity) {
		currentSession().update(entity);
	}

	@Override
	public void delete(E entity) {
		currentSession().delete(entity);
	}

	@Override
	public int deleteById(K id) {
		Query query = currentSession().createQuery("DELETE FROM " + daoType.getName() + " WHERE ID = :id");
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	/**
	 * To delete records by a column value
	 * 
	 * @param colName  Name of a database column. The column must belong to the
	 *                 table which this DAO is associated to.
	 * @param colValue A value to delete matching records
	 * @return The number of records deleted
	 */
	protected int deleteByColValue(String colName, Object colValue) {
		Query query;
		if (colValue == null) {
			query = currentSession().createQuery("DELETE FROM " + daoType.getName() + " WHERE " + colName + " IS NULL");
		} else {
			query = currentSession()
					.createQuery("DELETE FROM " + daoType.getName() + " WHERE " + colName + " = :colValue");
			query.setParameter("colValue", colValue);
		}

		return query.executeUpdate();
	}

	/**
	 * To delete records by a list of values in a column
	 * 
	 * @param colName  Name of a database column. The column must belong to the
	 *                 table which this DAO is associated to.
	 * @param colValue A list values to delete matching records
	 * @return The number of records deleted
	 */
	protected int deleteByColValues(String colName, List<Object> colValues) {
		Query query;
		if (CollectionUtils.isEmpty(colValues)) {
			return deleteByColValue(colName, null);
		} else {
			query = currentSession()
					.createQuery("DELETE FROM " + daoType.getName() + " WHERE " + colName + " IN (:colValue)");
			query.setParameter("colValue", colValues);
		}

		return query.executeUpdate();
	}

	@Override
	public E getById(K id) {
		return (E) currentSession().get(daoType, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list(int startIdx, int noOfResults) {
		if (startIdx < 0) {
			startIdx = 0;
		}

		if (noOfResults <= 0) {
			noOfResults = 25;
		}

		return currentSession().createQuery("FROM " + daoType.getName()).setFirstResult(startIdx)
				.setMaxResults(noOfResults).getResultList();
	}

	@Override
	public List<E> listActive(int startIdx, int noOfResults) {
		return listInternal(true, startIdx, noOfResults);
	}

	@Override
	public List<E> listInactive(int startIdx, int noOfResults) {
		return listInternal(false, startIdx, noOfResults);
	}

	/**
	 * To list entities with a filter on
	 * {@link com.angoor.common.model.EntityBase#isActive isActive} property
	 * 
	 * @param isActive      Set to {@code true} for active entities and
	 *                      {@code false} for inactive entities
	 * @param startIdxstart Index from which the result should include the entities.
	 *                      For a value < 0 it will be set to 0.
	 * @param noOfResults   Maximum number of entities to be included in the result.
	 *                      For a value <= 0, it will be set to 25.
	 * @return A list of entities filtered based {@code isActive} parameter
	 */
	@SuppressWarnings("unchecked")
	private List<E> listInternal(boolean isActive, int startIdx, int noOfResults) {
		if (startIdx < 0) {
			startIdx = 0;
		}

		if (noOfResults <= 0) {
			noOfResults = 25;
		}

		return currentSession().createQuery("FROM " + daoType.getName()).setParameter("IS_ACTIVE", isActive)
				.setFirstResult(startIdx).setMaxResults(noOfResults).getResultList();
	}
}
