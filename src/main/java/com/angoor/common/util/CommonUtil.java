/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.util;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public class CommonUtil {
	/**
	 * To get a valid value for start index - usually to fetch the records
	 * 
	 * @param startIdx A start index value (may be {@code null})
	 * @return 0 if the given {@code startIdx} is less than 0; otherwise, the given
	 *         {@code startIdx}
	 */
	public static int getValidStartIdx(Integer startIdx) {
		if (startIdx == null || startIdx < 0) {
			return 0;
		}

		return startIdx;
	}

	/**
	 * To get a valid value for no of results - usually to fetch the records
	 * 
	 * @param noOfResults Number of results (may be {@code null})
	 * @return 0 if the given {@code noOfResults} is either {@code null} or less
	 *         than 1; otherwise, the given {@code noOfResults}
	 */
	public static int getValidNoOfResults(Integer noOfResults) {
		if (noOfResults == null || noOfResults < 1) {
			return 25;
		}

		return noOfResults;
	}
}
