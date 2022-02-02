/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.angoor.securesociety.model.Dwelling;
import com.angoor.securesociety.service.DwellingService;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Controller
@Transactional
@RequestMapping("/dwellings")
public class DwellingsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DwellingsAPIController.class);

	@Autowired
	private DwellingService dwellingService;

	@GetMapping
	public ModelAndView listDwellings() {
		LOGGER.info("List dwellings");
		List<Dwelling> dwellingsList = dwellingService.list(0, 100);
		ModelAndView mv = new ModelAndView("dwelling/dwellingsList");
		mv.addObject("dwellingsList", dwellingsList);
		return mv;
	}
}
