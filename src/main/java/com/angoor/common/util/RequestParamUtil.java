/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.util;

import javax.swing.SortOrder;

/**
 * A utility class for processing
 * {@link org.springframework.web.bind.annotation.RequestParam RequestParam}
 * values
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public class RequestParamUtil {
	/**
	 * To convert a given sort order string value to {@link SortOrder}.<br/>
	 * If the given sort order string is <i>DESC</i> or <i>desc</i> then it returns
	 * {@link SortOrder#DESCENDING}; otherwise, returns {@link SortOrder#ASCENDING}
	 * 
	 * @param sortOrderStr Sort order as string
	 * @return If {@code sortOrderStr} is <i>DESC</i> or <i>desc</i> then
	 *         {@link SortOrder#DESCENDING}; otherwise, {@link SortOrder#ASCENDING}
	 */
	public static SortOrder convertToSortOrder(String sortOrderStr) {
		SortOrder sortOrder = SortOrder.ASCENDING;
		if (sortOrderStr != null && "DESC".equalsIgnoreCase(sortOrderStr)) {
			sortOrder = SortOrder.DESCENDING;
		}

		return sortOrder;
	}
}
