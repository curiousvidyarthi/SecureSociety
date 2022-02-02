/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.service;

import java.util.List;

import javax.swing.SortOrder;

import com.angoor.common.service.GenericService;
import com.angoor.contacts.model.NameSuffix;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public interface NameSuffixService extends GenericService<NameSuffix, Long> {
	/**
	 * To get a list of all active {@link NameSuffix}
	 * 
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list containing only active {@link NameSuffix}
	 */
	public List<NameSuffix> getActiveNameSuffixes(int startIdx, int noOfResults);

	/**
	 * To list name suffixes sorted by their name
	 * 
	 * @param sortOrder   {@link SortOrder} specifying the order of sorting
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list of name suffixes
	 */
	List<NameSuffix> list(SortOrder sortOrder, int startIdx, int noOfResults);
}
