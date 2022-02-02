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
import com.angoor.contacts.dao.NameSuffixDAO;
import com.angoor.contacts.model.NameSuffix;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class NameSuffixServiceImpl extends GenericServiceImpl<NameSuffix, Long> implements NameSuffixService {
	private NameSuffixDAO nameSuffixDao;

	public NameSuffixServiceImpl() {
	}

	@Autowired
	public NameSuffixServiceImpl(@Qualifier("nameSuffixDAOImpl") GenericDAO<NameSuffix, Long> genericDao) {
		super(genericDao);
		this.nameSuffixDao = (NameSuffixDAO) genericDao;
	}

	@Override
	public List<NameSuffix> getActiveNameSuffixes(int startIdx, int noOfResults) {
		return nameSuffixDao.listActive(startIdx, noOfResults);
	}

	@Override
	public List<NameSuffix> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		return nameSuffixDao.list(sortOrder, startIdx, noOfResults);
	}
}
