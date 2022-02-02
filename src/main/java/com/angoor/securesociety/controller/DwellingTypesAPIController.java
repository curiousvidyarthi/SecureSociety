/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angoor.common.exception.ResourceNotFoundException;
import com.angoor.securesociety.model.DwellingType;
import com.angoor.securesociety.service.DwellingTypeService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/dwelling-types")
public class DwellingTypesAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DwellingTypesAPIController.class);
	
	@Autowired
	private DwellingTypeService dwellingTypeService;

	@PostMapping
	public DwellingType addDwellingType(@Valid @RequestBody DwellingType dwellingType) {
		dwellingTypeService.add(dwellingType);
		return dwellingType;
	}

	@GetMapping("/{id}")
	public DwellingType getDwellingTypeById(@PathVariable("id") long id) throws ResourceNotFoundException {
		DwellingType dwellingType = dwellingTypeService.getById(id);
		if (dwellingType == null) {
			LOGGER.info("No dwelling type found for ID: {}", id);
			throw new ResourceNotFoundException();
		}
		
		return dwellingType;
	}

	@GetMapping
	public List<DwellingType> listDwellingTypes() {
		List<DwellingType> dwellingTypesList = dwellingTypeService.list(0, 10);
		return dwellingTypesList;
	}
}
