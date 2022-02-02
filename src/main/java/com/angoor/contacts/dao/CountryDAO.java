/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.dao;

import java.util.List;

import javax.swing.SortOrder;

import com.angoor.common.dao.GenericDAO;
import com.angoor.contacts.model.Country;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public interface CountryDAO extends GenericDAO<Country, Long> {
	/**
	 * To search a country by {@link Country#countryCode} or
	 * {@link Country#countryName}
	 * 
	 * @param searchStr   A search string
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list containing matching {@link Country}
	 */
	public List<Country> searchCountry(String searchStr, int startIdx, int noOfResults);

	/**
	 * /** To list countries sorted by country name
	 * 
	 * @param sortOrder   {@link SortOrder} specifying the order of sorting
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list of countries
	 */
	List<Country> list(SortOrder sortOrder, int startIdx, int noOfResults);
}
