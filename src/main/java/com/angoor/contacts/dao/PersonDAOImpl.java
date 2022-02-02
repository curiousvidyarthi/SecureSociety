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
import com.angoor.contacts.model.Person;
import com.angoor.contacts.util.ContactsSortBy;
import com.angoor.contacts.util.ContactsUtil;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public class PersonDAOImpl extends GenericDAOImpl<Person, Long> implements PersonDAO {
	@Override
	public List<Person> searchPerson(String searchStr, int startIdx, int noOfResults) {
		// TODO: Include Email and other fields for search
		String qryStr = "SELECT * FROM PEOPLE WHERE LOWER(FIRST_NAME) LIKE LOWER(:firstName) OR LOWER(MIDDLE_NAME) LIKE LOWER(:middleName) OR LOWER(LAST_NAME) LIKE LOWER(:lastName)"
				+ getPeopleOrderByClause(ContactsUtil.getContactsSortBy(), SortOrder.ASCENDING);

		Query<Person> query = currentSession().createNativeQuery(qryStr, Person.class);
		query.setParameter("firstName", searchStr + "%");
		query.setParameter("middleName", searchStr + "%");
		query.setParameter("lastName", searchStr + "%");
		query.setFirstResult(startIdx).setMaxResults(noOfResults);
		List<Person> matchingPeople = query.list();

		int matchingPeopleCount = matchingPeople.size();
		if (matchingPeopleCount < noOfResults) {
			// TODO: Check if the query needs to be re-created
			query.setParameter("firstName", "%" + searchStr + "%");
			query.setParameter("middleName", "%" + searchStr + "%");
			query.setParameter("lastName", "%" + searchStr + "%");
			List<Person> tempMatchingPeople = query.list();
			for (Person person : tempMatchingPeople) {
				if (!matchingPeople.contains(person)) {
					matchingPeople.add(person);
				}
			}
		}

		return matchingPeople;
	}

	/**
	 * To get the ORDER BY clause for selecting records from {@link People} table
	 * using SQL queries
	 * 
	 * @param sortBy    {@link ContactsSortBy} specifying column to apply sorting
	 * @param sortOrder {@link SortOrder} specifying the order of sorting
	 * @return ORDER BY clause for selecting records from {@link People} table using
	 *         SQL queries
	 */
	private String getPeopleOrderByClause(ContactsSortBy sortBy, SortOrder sortOrder) {
		String orderByClause;
		switch (sortBy) {
		case FIRST_NAME:
			orderByClause = " ORDER BY FIRST_NAME";
			break;
		default:
			orderByClause = " ORDER BY LAST_NAME";
			break;
		}

		if (sortOrder == SortOrder.DESCENDING) {
			orderByClause += " DESC";
		}

		return orderByClause;
	}

	@Override
	public List<Person> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		Query<Person> query = currentSession().createQuery(
				"FROM " + daoType.getName() + getPeopleOrderByClause(ContactsUtil.getContactsSortBy(), sortOrder),
				Person.class);
		return query.setFirstResult(startIdx).setMaxResults(noOfResults).getResultList();
	}
}
