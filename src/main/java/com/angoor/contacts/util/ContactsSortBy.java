/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.util;

/**
 * Enumeration which specifies a column by which contacts are/to be sorted
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public enum ContactsSortBy {
	/**
	 * Enumeration value indicating the contacts are sorted by their first name
	 */
	FIRST_NAME,

	/**
	 * Enumeration value indicating the contacts are sorted by their last name
	 */
	LAST_NAME,
	/**
	 * Enumeration value indicating the contacts are sorted by their usage count
	 */
	USAGE_COUNT
}
