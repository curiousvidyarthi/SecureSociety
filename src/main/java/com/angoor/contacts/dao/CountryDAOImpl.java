/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.dao;

import java.util.List;

import javax.swing.SortOrder;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.angoor.common.dao.GenericDAOImpl;
import com.angoor.contacts.model.Country;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public class CountryDAOImpl extends GenericDAOImpl<Country, Long> implements CountryDAO {
	@Override
	public List<Country> searchCountry(String searchStr, int startIdx, int noOfResults) {
		Query<Country> query = currentSession().createNativeQuery(
				"SELECT * FROM COUNTRIES WHERE LOWER(COUNTRY_CODE) LIKE LOWER(:countryCode) OR LOWER(COUNTRY_NAME) LIKE LOWER(:countryName) ORDER BY COUNTRY_NAME",
				Country.class);
		query.setParameter("countryCode", searchStr + "%");
		query.setParameter("countryName", searchStr + "%");
		query.setFirstResult(startIdx).setMaxResults(noOfResults);
		List<Country> matchingCountries = query.list();

		int matchingCountriesCount = matchingCountries.size();
		if (matchingCountriesCount < noOfResults) {
			// TODO: Check if the query needs to be re-created
			query.setParameter("countryCode", "%" + searchStr + "%");
			query.setParameter("countryName", "%" + searchStr + "%");
			List<Country> tempMatchingCountries = query.list();
			for (Country country : tempMatchingCountries) {
				if (!matchingCountries.contains(country)) {
					matchingCountries.add(country);
				}
			}
		}

		return matchingCountries;
	}

	@Override
	public List<Country> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		Query<Country> query;
		if (sortOrder != SortOrder.DESCENDING) {
			query = currentSession().createQuery("FROM " + daoType.getName() + " ORDER BY COUNTRY_NAME", Country.class);
		} else {
			query = currentSession().createQuery("FROM " + daoType.getName() + " ORDER BY COUNTRY_NAME DESC",
					Country.class);
		}

		return query.setFirstResult(startIdx).setMaxResults(noOfResults).getResultList();
	}
}
