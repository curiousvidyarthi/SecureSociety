/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.service;

import java.util.List;

import javax.swing.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.angoor.common.dao.GenericDAO;
import com.angoor.common.service.GenericServiceImpl;
import com.angoor.contacts.dao.NamePrefixDAO;
import com.angoor.contacts.model.NamePrefix;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class NamePrefixServiceImpl extends GenericServiceImpl<NamePrefix, Long> implements NamePrefixService {
	private NamePrefixDAO namePrefixDao;

	public NamePrefixServiceImpl() {
	}

	@Autowired
	public NamePrefixServiceImpl(@Qualifier("namePrefixDAOImpl") GenericDAO<NamePrefix, Long> genericDao) {
		super(genericDao);
		this.namePrefixDao = (NamePrefixDAO) genericDao;
	}

	@Override
	public List<NamePrefix> getActiveNamePrefixes(int startIdx, int noOfResults) {
		return namePrefixDao.listActive(startIdx, noOfResults);
	}

	@Override
	public List<NamePrefix> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		return namePrefixDao.list(sortOrder, startIdx, noOfResults);
	}
}
