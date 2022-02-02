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
import com.angoor.contacts.model.MaritalStatus;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public class MaritalStatusDAOImpl extends GenericDAOImpl<MaritalStatus, Long> implements MaritalStatusDAO {
	@Override
	public List<MaritalStatus> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		Query<MaritalStatus> query;
		if (sortOrder != SortOrder.DESCENDING) {
			query = currentSession().createQuery("FROM " + daoType.getName() + " ORDER BY MARITAL_STATUS",
					MaritalStatus.class);
		} else {
			query = currentSession().createQuery("FROM " + daoType.getName() + " ORDER BY MARITAL_STATUS DESC",
					MaritalStatus.class);
		}

		return query.setFirstResult(startIdx).setMaxResults(noOfResults).getResultList();
	}
}
