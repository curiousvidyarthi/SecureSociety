/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.util;

/**
 * Defines response status
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public enum ResponseStatus {
	/**
	 * Indicates that the request was processed successfully
	 */
	SUCCESS,

	/**
	 * Indicates that the request was processed with partial success.<br/>
	 * For example, only 5 records are deleted when requested for 10.
	 */
	PARTIAL,

	/**
	 * Indicates that the request processing was failed
	 */
	FAILED,
}
