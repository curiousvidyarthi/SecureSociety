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
import com.angoor.contacts.model.MaritalStatus;
import com.angoor.contacts.service.MaritalStatusService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/marital-status")
public class MaritalStatusAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MaritalStatusAPIController.class);

	@Autowired
	private MaritalStatusService maritalStatusService;

	@PostMapping
	public MaritalStatus addMaritalStatus(@Valid @RequestBody MaritalStatus maritalStatus) {
		maritalStatusService.add(maritalStatus);
		return maritalStatus;
	}

	@GetMapping("/{id}")
	public MaritalStatus getMaritalStatusById(@PathVariable("id") long id) throws ResourceNotFoundException {
		MaritalStatus maritalStatus = maritalStatusService.getById(id);
		if (maritalStatus == null) {
			LOGGER.info("No marital status found for ID: {}", id);
			throw new ResourceNotFoundException();
		}

		return maritalStatus;
	}

	@GetMapping
	public List<MaritalStatus> listMaritalStatus(
			@RequestParam(name = "sortOrder", required = false) String sortOrderStr,
			@RequestParam(name = "startIdx", required = false) Integer startIdx,
			@RequestParam(name = "noOfResults", required = false) Integer noOfResults) {
		List<MaritalStatus> maritalStatusList = maritalStatusService.list(
				RequestParamUtil.convertToSortOrder(sortOrderStr), CommonUtil.getValidStartIdx(startIdx),
				CommonUtil.getValidNoOfResults(noOfResults));
		return maritalStatusList;
	}
}
