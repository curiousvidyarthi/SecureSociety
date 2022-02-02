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
import com.angoor.contacts.dao.CountryDAO;
import com.angoor.contacts.model.Country;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class CountryServiceImpl extends GenericServiceImpl<Country, Long> implements CountryService {
	private CountryDAO countryDAO;

	public CountryServiceImpl() {
	}

	@Autowired
	public CountryServiceImpl(@Qualifier("countryDAOImpl") GenericDAO<Country, Long> genericDAO) {
		super(genericDAO);
		this.countryDAO = (CountryDAO) genericDAO;
	}

	@Override
	public List<Country> searchCountry(String searchStr, int startIdx, int noOfResults) {
		return countryDAO.searchCountry(searchStr, startIdx, noOfResults);
	}

	@Override
	public List<Country> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		return countryDAO.list(sortOrder, startIdx, noOfResults);
	}
}
