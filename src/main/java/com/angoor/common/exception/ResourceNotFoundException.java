/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Not found");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
