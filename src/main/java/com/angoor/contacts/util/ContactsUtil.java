/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.util;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public class ContactsUtil {
	/**
	 * To get {@link ContactsSortBy} value based on configurations. The returned
	 * value specifies a column to sort contacts.
	 * 
	 * @return {@link ContactsSortBy} specifying a column to sort contacts
	 */
	public static ContactsSortBy getContactsSortBy() {
		return ContactsSortBy.FIRST_NAME;
	}
}
