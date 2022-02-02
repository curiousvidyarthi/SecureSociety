/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.util;

import lombok.Getter;
import lombok.Setter;

/**
 * ErrorResponse class allows to send a failed response status with proper error
 * code and error message in a common way for API responses. The error message,
 * if any, should be sent in the {@code data} property.
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public class ErrorResponse extends Response<String> {
	/**
	 * Initializes response {@link status} of this instance with
	 * {@link ResponseStatus#FAILED}
	 */
	public ErrorResponse() {
		super(ResponseStatus.FAILED);
	}

	/**
	 * Error code which can be consumed by the client
	 */
	@Getter
	@Setter
	private int errorCode;
}
