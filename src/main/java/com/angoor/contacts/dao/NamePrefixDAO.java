/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.dao;

import java.util.List;

import javax.swing.SortOrder;

import com.angoor.common.dao.GenericDAO;
import com.angoor.contacts.model.NamePrefix;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public interface NamePrefixDAO extends GenericDAO<NamePrefix, Long> {
	/**
	 * To list name prefixes sorted by their name
	 * 
	 * @param sortOrder   Specifies {@link SortOrder} to sort the results
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list of name prefixes
	 */
	List<NamePrefix> list(SortOrder sortOrder, int startIdx, int noOfResults);
}
