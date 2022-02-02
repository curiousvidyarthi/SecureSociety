/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.angoor.common.model.EntityBase;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Entity
@Table(name = "ADDRESSES")
public class Address extends EntityBase {
	/**
	 * Address line one
	 */
	@Column(name = "ADDR_LINE_ONE", length = 100)
	@Getter
	@Setter
	private String addressLineOne;

	/**
	 * Address line two
	 */
	@Column(name = "ADDR_LINE_TWO", length = 100)
	@Getter
	@Setter
	private String addressLineTwo;

	/**
	 * Locality / area name
	 */
	@Column(name = "LOCALITY", length = 50)
	@Getter
	@Setter
	private String locality;

	/**
	 * City name
	 */
	@Column(name = "CITY", length = 50)
	@Getter
	@Setter
	private String city;

	/**
	 * State name
	 */
	@Column(name = "STATE", length = 50)
	@Getter
	@Setter
	private String state;

	/**
	 * Country
	 */
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private Country country;

	/**
	 * Postal code
	 */
	@Column(name = "POSTALCODE", length = 10)
	@Getter
	@Setter
	private String postalCode;
}
