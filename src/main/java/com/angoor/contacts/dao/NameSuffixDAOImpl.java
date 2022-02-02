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
import com.angoor.contacts.model.NameSuffix;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public class NameSuffixDAOImpl extends GenericDAOImpl<NameSuffix, Long> implements NameSuffixDAO {
	@Override
	public List<NameSuffix> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		Query<NameSuffix> query;
		if (sortOrder != SortOrder.DESCENDING) {
			query = currentSession().createQuery("FROM " + daoType.getName() + " ORDER BY NAME_SUFFIX",
					NameSuffix.class);
		} else {
			query = currentSession().createQuery("FROM " + daoType.getName() + " ORDER BY NAME_SUFFIX DESC",
					NameSuffix.class);
		}

		return query.setFirstResult(startIdx).setMaxResults(noOfResults).getResultList();
	}
}
