/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.exception;

import java.util.Date;

import lombok.Getter;

/**
 * {@code ErrorDetails} class can be used to send common error message when an
 * API request causes exception
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public class ErrorDetails {
	/**
	 * Timestamp when this instance was created
	 */
	@Getter
	private Date timestamp;

	/**
	 * Error message of this instance
	 */
	@Getter
	private String message;

	/**
	 * Error details of this instance
	 */
	@Getter
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	@Override
	public String toString() {
		return "{\"timestamp\": " + timestamp + ", \"message\": " + message + ", \"details\": " + details + "}";
	}
}
