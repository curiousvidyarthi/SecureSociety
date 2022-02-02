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
import com.angoor.contacts.model.NameSuffix;
import com.angoor.contacts.service.NameSuffixService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/name-suffixes")
public class NameSuffixesAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NameSuffixesAPIController.class);

	@Autowired
	private NameSuffixService nameSuffixService;

	@PostMapping
	public NameSuffix addNameSuffix(@Valid @RequestBody NameSuffix nameSuffix) {
		nameSuffixService.add(nameSuffix);
		return nameSuffix;
	}

	@GetMapping("/{id}")
	public NameSuffix getNameSuffixById(@PathVariable("id") long id) throws ResourceNotFoundException {
		NameSuffix nameSuffix = nameSuffixService.getById(id);
		if (nameSuffix == null) {
			LOGGER.info("No name suffix found for ID: {}", id);
			throw new ResourceNotFoundException();
		}

		return nameSuffix;
	}

	@GetMapping
	public List<NameSuffix> listNameSuffixes(@RequestParam(name = "sortOrder", required = false) String sortOrderStr,
			@RequestParam(name = "startIdx", required = false) Integer startIdx,
			@RequestParam(name = "noOfResults", required = false) Integer noOfResults) {
		List<NameSuffix> nameSuffixesList = nameSuffixService.list(RequestParamUtil.convertToSortOrder(sortOrderStr),
				CommonUtil.getValidStartIdx(startIdx), CommonUtil.getValidNoOfResults(noOfResults));
		return nameSuffixesList;
	}
}
