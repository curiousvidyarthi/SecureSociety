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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angoor.common.exception.ResourceNotFoundException;
import com.angoor.common.util.CommonUtil;
import com.angoor.common.util.RequestParamUtil;
import com.angoor.common.util.Response;
import com.angoor.common.util.ResponseStatus;
import com.angoor.contacts.model.Country;
import com.angoor.contacts.service.CountryService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/countries")
public class CountriesAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountriesAPIController.class);

	@Autowired
	private CountryService countryService;

	@PostMapping
	public Country addCountry(@Valid @RequestBody Country country) {
		LOGGER.info("Adding a country details");
		countryService.add(country);

		return country;
	}

	@PutMapping
	public Country UpdateCountry(@Valid @RequestBody Country country) {
		if (country.getId() == 0L) {
			throw new IllegalArgumentException("No ID provided for updating country");
		}

		LOGGER.info("Updating the details of a country with ID: {}", country.getId());
		countryService.update(country); // Here it does not throw an exception even if the ID doesn't exist in DB
		return country;
	}

	@DeleteMapping("/{id}")
	public Response<Integer> deleteCountryById(@PathVariable("id") long id) throws ResourceNotFoundException {
		int deletedCount = countryService.deleteById(id);

		if (deletedCount > 0) {
			LOGGER.info("Deleted country with ID: {}. Deleted count: {}", id, deletedCount);
			Response<Integer> response = new Response<Integer>(ResponseStatus.SUCCESS);
			response.setData(deletedCount);
			return response;
		} else {
			LOGGER.info("No country found to delete for ID: {}", id);
			throw new ResourceNotFoundException();
		}
	}

	@GetMapping("/{id}")
	public Country getCountryById(@PathVariable("id") long id) throws ResourceNotFoundException {
		Country country = countryService.getById(id);
		if (country == null) {
			LOGGER.info("No country found for ID: {}", id);
			throw new ResourceNotFoundException();
		}

		return country;
	}

	@GetMapping("/search")
	public List<Country> searchCountry(@RequestParam("searchStr") String searchStr,
			@RequestParam(name = "startIdx", required = false) int startIdx,
			@RequestParam(name = "noOfResults", required = false) int noOfResults) {
		List<Country> countriesList = null;
		if (StringUtils.hasText(searchStr)) {
			countriesList = countryService.searchCountry(searchStr, CommonUtil.getValidStartIdx(startIdx),
					CommonUtil.getValidNoOfResults(noOfResults));
			if (CollectionUtils.isEmpty(countriesList)) {
				LOGGER.info("No matching country found for: {}", searchStr);
			}
		}

		return countriesList;
	}

	@GetMapping
	public List<Country> listCountries(@RequestParam(name = "sortOrder", required = false) String sortOrderStr,
			@RequestParam(name = "startIdx", required = false) Integer startIdx,
			@RequestParam(name = "noOfResults", required = false) Integer noOfResults) {
		List<Country> countriesList = countryService.list(RequestParamUtil.convertToSortOrder(sortOrderStr),
				CommonUtil.getValidStartIdx(startIdx), CommonUtil.getValidNoOfResults(noOfResults));
		return countriesList;
	}
}
