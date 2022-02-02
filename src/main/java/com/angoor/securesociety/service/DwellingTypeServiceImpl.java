/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.angoor.common.dao.GenericDAO;
import com.angoor.common.service.GenericServiceImpl;
import com.angoor.securesociety.dao.DwellingTypeDAO;
import com.angoor.securesociety.model.DwellingType;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class DwellingTypeServiceImpl extends GenericServiceImpl<DwellingType, Long> implements DwellingTypeService {
	private DwellingTypeDAO dwellingTypeDao;

	public DwellingTypeServiceImpl() {
	}

	@Autowired
	public DwellingTypeServiceImpl(@Qualifier("dwellingTypeDAOImpl") GenericDAO<DwellingType, Long> genericDao) {
		super(genericDao);
		this.dwellingTypeDao = (DwellingTypeDAO) genericDao;
	}

	@Override
	public List<DwellingType> getActiveDwellingTypes(int startIdx, int noOfResults) {
		return dwellingTypeDao.listActive(startIdx, noOfResults);
	}

	@Override
	public List<DwellingType> getInactiveDwellingTypes(int startIdx, int noOfResults) {
		return dwellingTypeDao.listInactive(startIdx, noOfResults);
	}
}
