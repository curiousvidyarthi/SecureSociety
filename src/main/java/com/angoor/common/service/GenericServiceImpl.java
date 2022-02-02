/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.angoor.common.dao.GenericDAO;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class GenericServiceImpl<E, K extends Serializable> implements GenericService<E, K> {
	private GenericDAO<E, K> genericDao;

	public GenericServiceImpl(GenericDAO<E, K> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericServiceImpl() {
	}

	@Override
	public void add(E entity) {
		genericDao.add(entity);
	}

	@Override
	public void addOrUpdate(E entity) {
		genericDao.addOrUpdate(entity);
	}

	@Override
	public void update(E entity) {
		genericDao.update(entity);
	}

	@Override
	public void delete(E entity) {
		genericDao.delete(entity);
	}

	@Override
	public int deleteById(K id) {
		return genericDao.deleteById(id);
	}

	@Override
	public E getById(K id) {
		return genericDao.getById(id);
	}

	@Override
	public List<E> list(int startIdx, int noOfResults) {
		return genericDao.list(startIdx, noOfResults);
	}

	@Override
	public List<E> listActive(int startIdx, int noOfResults) {
		return genericDao.listActive(startIdx, noOfResults);
	}

	@Override
	public List<E> listInactive(int startIdx, int noOfResults) {
		return genericDao.listInactive(startIdx, noOfResults);
	}
}
