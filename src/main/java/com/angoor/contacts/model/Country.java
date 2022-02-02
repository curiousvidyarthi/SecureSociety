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
@Table(name = "COUNTRIES")
public class Country extends EntityBase {
	/**
	 * Country code like IND, USA, etc. It can be used for searching a country.
	 */
	@Column(name = "COUNTRY_CODE")
	@Getter
	@Setter
	private String countryCode;

	/**
	 * Country name
	 */
	@Column(name = "COUNTRY_NAME")
	@Getter
	@Setter
	private String countryName;

	/**
	 * Indicates whether some other object is "equal to" this {@link Country}.<br/>
	 * For a non-null reference {@code obj} it returns true only if {@code id} of
	 * this object and that of the reference {@code obj} are same.
	 * 
	 * @param obj A reference object with which to compare
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { // Self check
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) { // NULL and type check
			return false;
		}

		Country countryObj = (Country) obj;
		return this.id == countryObj.id; // Primary-key/Field comparison
	}

	/**
	 * Returns the hash code value of {@code id} of this object
	 */
	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}
}
