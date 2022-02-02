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
import com.angoor.securesociety.model.Dwelling;
import com.angoor.securesociety.service.DwellingService;
import com.angoor.securesociety.service.DwellingTypeService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/dwellings")
public class DwellingsAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DwellingsAPIController.class);

	@Autowired
	private DwellingService dwellingService;
	@Autowired
	DwellingTypeService dwellingTypeService;

	@PostMapping
	public Dwelling addDwelling(@Valid @RequestBody Dwelling dwelling) {
		// DwellingType dwellingType =
		// dwellingTypeService.getById(dwelling.getDwellingType().getId());
		dwellingService.add(dwelling);
		return dwelling;
	}

	@GetMapping("/{id}")
	public Dwelling getDwelling(@PathVariable("id") long id) throws ResourceNotFoundException {
		Dwelling dwelling = dwellingService.getById(id);
		if (dwelling == null) {
			LOGGER.info("No dwelling found for ID: {}", id);
			throw new ResourceNotFoundException();
		}

		return dwelling;
	}

	@GetMapping
	public List<Dwelling> listDwellings() {
		List<Dwelling> dwellingsList = dwellingService.list(0, 100);
		LOGGER.debug("List dwellings. Count: {}", dwellingsList.size());
		return dwellingsList;
	}
}
