/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.service;

import java.util.List;

import com.angoor.common.service.GenericService;
import com.angoor.securesociety.model.Dwelling;
import com.angoor.securesociety.model.DwellingType;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public interface DwellingService extends GenericService<Dwelling, Long> {
	/**
	 * To get a list of {@link Dwelling} by specified {@code dwellingTypeId}
	 * 
	 * @param dwelingTypeId {@code Id} of a {@link DwellingType} to get dwellings
	 * @return a list of {@link Dwelling}
	 */
	public List<Dwelling> getDwellingsByType(long dwellingTypeId);
}
