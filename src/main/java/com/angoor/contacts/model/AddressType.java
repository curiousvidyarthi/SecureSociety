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
 * Address type specifies the usage/type of an {@link Address}. For example -
 * Office address, Residence address, etc.
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Entity
@Table(name = "ADDRESS_TYPES")
public class AddressType extends EntityBase {
	/**
	 * Meaningful label of this address type like "Office address"
	 */
	@Column(name = "TYPE")
	@Getter
	@Setter
	private String type;

	/**
	 * Description of this address type
	 */
	@Column(name = "DESCRIPTION")
	@Getter
	@Setter
	private String description;
}
