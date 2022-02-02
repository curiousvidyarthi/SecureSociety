/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.service;

import java.util.List;

import com.angoor.common.service.GenericService;
import com.angoor.securesociety.model.DwellingType;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public interface DwellingTypeService extends GenericService<DwellingType, Long> {
	/**
	 * To get a list of all active {@link DwellingType}
	 * 
	 * @param startIdx    Index from which the result should include the entities.
	 *                    For a value < 0 it will be set to 0.
	 * @param noOfResults Maximum number of entities to be included in the result.
	 * @return A list containing only active {@link DwellingType}
	 */
	public List<DwellingType> getActiveDwellingTypes(int startIdx, int noOfResults);

	/**
	 * To get a list of all inactive {@link DwellingType}
	 * 
	 * @param startIdx    Index from which the result should include the entities.
	 *                    For a value < 0 it will be set to 0.
	 * @param noOfResults Maximum number of entities to be included in the result.
	 * @return A list containing only inactive {@link DwellingType}
	 */
	public List<DwellingType> getInactiveDwellingTypes(int startIdx, int noOfResults);
}
