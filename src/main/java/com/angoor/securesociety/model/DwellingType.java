/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.angoor.common.model.EntityBase;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Entity
@Table(name = "DWELLING_TYPES")
public class DwellingType extends EntityBase {
	/**
	 * Dwelling type code
	 */
	@Column(name = "TYPE_CODE")
	@Getter
	@Setter
	private String typeCode;

	/**
	 * Dwelling type name
	 */
	@Column(name = "TYPE_NAME")
	@Getter
	@Setter
	private String typeName;
}
