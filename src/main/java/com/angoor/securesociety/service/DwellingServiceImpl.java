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
import com.angoor.securesociety.dao.DwellingDAO;
import com.angoor.securesociety.model.Dwelling;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class DwellingServiceImpl extends GenericServiceImpl<Dwelling, Long> implements DwellingService {
	private DwellingDAO dwellingDao;

	public DwellingServiceImpl() {
	}

	@Autowired
	public DwellingServiceImpl(@Qualifier("dwellingDAOImpl") GenericDAO<Dwelling, Long> genericDao) {
		super(genericDao);
		this.dwellingDao = (DwellingDAO) genericDao;
	}

	@Override
	public List<Dwelling> getDwellingsByType(long dwellingTypeId) {
		return dwellingDao.getDwellingsByType(dwellingTypeId);
	}
}
