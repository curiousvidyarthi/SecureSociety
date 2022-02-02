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
@Table(name = "MARITAL_STATUS")
public class MaritalStatus extends EntityBase {
	/**
	 * Marital status like Single, In Relation, Married, Separated, Divorced, and/or
	 * Widowed
	 */
	@Column(name = "MARITAL_STATUS")
	@Getter
	@Setter
	private String maritalStatus;

	/**
	 * Description of this name prefix
	 */
	@Column(name = "DESCRIPTION")
	@Getter
	@Setter
	private String description;
}
