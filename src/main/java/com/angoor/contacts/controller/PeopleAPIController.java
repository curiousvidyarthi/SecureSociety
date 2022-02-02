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
import com.angoor.contacts.model.Person;
import com.angoor.contacts.service.PersonService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@RestController
@Transactional
@RequestMapping("/api/v1/people")
public class PeopleAPIController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleAPIController.class);

	@Autowired
	private PersonService personService;

	@PostMapping
	public Person addOrUpdatePerson(@Valid @RequestBody Person person) {
		if (person.getId() != 0L) {
			LOGGER.info("Updating the details of a person with ID: {}", person.getId());
			personService.update(person); // Here it does not throw an exception even if the ID doesn't exist in DB
		} else {
			LOGGER.info("Adding a person details");
			personService.add(person);
		}

		return person;
	}

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable("id") long id) throws ResourceNotFoundException {
		Person person = personService.getById(id);
		if (person == null) {
			LOGGER.info("No person found for ID: {}", id);
			throw new ResourceNotFoundException();
		}

		return person;
	}

	@GetMapping
	public List<Person> listPeople(@RequestParam(name = "sortOrder", required = false) String sortOrderStr,
			@RequestParam(name = "startIdx", required = false) Integer startIdx,
			@RequestParam(name = "noOfResults", required = false) Integer noOfResults) {
		List<Person> peopleList = personService.list(RequestParamUtil.convertToSortOrder(sortOrderStr),
				CommonUtil.getValidStartIdx(startIdx), CommonUtil.getValidNoOfResults(noOfResults));
		return peopleList;
	}
}
