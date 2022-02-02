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
import com.angoor.contacts.dao.MaritalStatusDAO;
import com.angoor.contacts.model.MaritalStatus;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class MaritalStatusServiceImpl extends GenericServiceImpl<MaritalStatus, Long> implements MaritalStatusService {
	private MaritalStatusDAO maritalStatusDao;

	public MaritalStatusServiceImpl() {
	}

	@Autowired
	public MaritalStatusServiceImpl(@Qualifier("maritalStatusDAOImpl") GenericDAO<MaritalStatus, Long> genericDao) {
		super(genericDao);
		this.maritalStatusDao = (MaritalStatusDAO) genericDao;
	}

	@Override
	public List<MaritalStatus> getActiveMaritalStatus(int startIdx, int noOfResults) {
		return maritalStatusDao.listActive(startIdx, noOfResults);
	}

	@Override
	public List<MaritalStatus> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		return maritalStatusDao.list(sortOrder, startIdx, noOfResults);
	}
}
