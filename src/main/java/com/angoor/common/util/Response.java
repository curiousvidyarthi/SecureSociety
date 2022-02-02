/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.util;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Response class can be used to send a response status and response data in a
 * common way for API responses
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public class Response<T extends Serializable> {
	/**
	 * Default constructor
	 */
	public Response() {
	}

	/**
	 * Initializes {@link status} of this instance with the specified {@code status}
	 * 
	 * @param status
	 */
	public Response(ResponseStatus status) {
		this.status = status;
	}

	/**
	 * Response status
	 */
	@Getter
	@Setter
	private ResponseStatus status;

	/**
	 * Response data
	 */
	@Getter
	@Setter
	private T data;
}
