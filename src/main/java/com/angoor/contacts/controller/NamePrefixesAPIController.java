/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angoor.common.exception.ResourceNotFoundException;
import com.angoor.common.util.CommonUtil;
import com.angoor.common.util.RequestParamUtil;
import com.angoor.contacts.model.NamePrefix;
import com.angoor.contacts.service.NamePrefixService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/name-prefixes")
public class NamePrefixesAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NamePrefixesAPIController.class);

	@Autowired
	private NamePrefixService namePrefixService;

	@PostMapping
	public NamePrefix addNamePrefix(@Valid @RequestBody NamePrefix namePrefix) {
		namePrefixService.add(namePrefix);
		return namePrefix;
	}

	@GetMapping("/{id}")
	public NamePrefix getNamePrefixById(@PathVariable("id") long id) throws ResourceNotFoundException {
		NamePrefix namePrefix = namePrefixService.getById(id);
		if (namePrefix == null) {
			LOGGER.info("No name prefix found for ID: {}", id);
			throw new ResourceNotFoundException();
		}

		return namePrefix;
	}

	@GetMapping
	public List<NamePrefix> listNamePrefixes(@RequestParam(name = "sortOrder", required = false) String sortOrderStr,
			@RequestParam(name = "startIdx", required = false) Integer startIdx,
			@RequestParam(name = "noOfResults", required = false) Integer noOfResults) {
		List<NamePrefix> namePrefixesList = namePrefixService.list(RequestParamUtil.convertToSortOrder(sortOrderStr),
				CommonUtil.getValidStartIdx(startIdx), CommonUtil.getValidNoOfResults(noOfResults));
		return namePrefixesList;
	}
}
