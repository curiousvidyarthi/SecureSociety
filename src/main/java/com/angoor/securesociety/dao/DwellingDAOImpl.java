/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.angoor.common.dao.GenericDAOImpl;
import com.angoor.securesociety.model.Dwelling;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public class DwellingDAOImpl extends GenericDAOImpl<Dwelling, Long> implements DwellingDAO {
	@Override
	public List<Dwelling> getDwellingsByType(long dwellingTypeId) {
		Query<Dwelling> query = currentSession()
				.createQuery("SELECT * FROM DWELLINGS WHERE DWELLING_TYPE_ID=:dwellingTypeId", Dwelling.class);
		query.setParameter("dwellingTypeId", dwellingTypeId);
		List<Dwelling> l = query.list();
		return query.list();
	}
}
