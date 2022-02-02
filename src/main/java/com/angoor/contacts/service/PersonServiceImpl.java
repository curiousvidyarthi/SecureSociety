/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.service;

import java.util.List;

import javax.swing.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.angoor.common.dao.GenericDAO;
import com.angoor.common.service.GenericServiceImpl;
import com.angoor.contacts.dao.PersonDAO;
import com.angoor.contacts.model.Person;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Service
public class PersonServiceImpl extends GenericServiceImpl<Person, Long> implements PersonService {
	@SuppressWarnings("unused")
	private PersonDAO personDao;

	public PersonServiceImpl() {
	}

	@Autowired
	public PersonServiceImpl(@Qualifier("personDAOImpl") GenericDAO<Person, Long> genericDao) {
		super(genericDao);
		this.personDao = (PersonDAO) genericDao;
	}

	@Override
	public List<Person> searchPerson(String searchStr, int startIdx, int noOfResults) {
		return personDao.searchPerson(searchStr, startIdx, noOfResults);
	}

	@Override
	public List<Person> list(SortOrder sortOrder, int startIdx, int noOfResults) {
		return personDao.list(sortOrder, startIdx, noOfResults);
	}
}
