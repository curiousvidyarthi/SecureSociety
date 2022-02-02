/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.model;

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
@Table(name = "NAME_SUFFIXES")
public class NameSuffix extends EntityBase {
	/**
	 * Name suffix like Jr., MD. etc.
	 */
	@Column(name = "NAME_SUFFIX")
	@Getter
	@Setter
	private String nameSuffix;

	/**
	 * Description of this name prefix
	 */
	@Column(name = "DESCRIPTION")
	@Getter
	@Setter
	private String description;
}
