/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@SuppressWarnings("serial")
public class HibernateAwareObjectMapper extends ObjectMapper {
	public HibernateAwareObjectMapper() {
		registerModule(new Hibernate5Module()); // Change 5 to 4 or 3 to support Hibernate 4 or 3
	}
}
