/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.model;

import java.util.Date;

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
@Table(name = "PEOPLE")
public class Person extends EntityBase {
	/**
	 * {@link NamePrefix} of this person
	 */
	@ManyToOne
	@JoinColumn(name = "NAME_PREFIX_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private NamePrefix namePrefix;

	/**
	 * {@link NameSuffix} of this person
	 */
	@ManyToOne
	@JoinColumn(name = "NAME_SUFFIX_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private NameSuffix nameSuffix;

	/**
	 * Initial of this person
	 */
	@Column(name = "INITIAL", length = 20)
	@Getter
	@Setter
	private String initial;

	/**
	 * First name of this person
	 */
	@Column(name = "FIRST_NAME", length = 50)
	@Getter
	@Setter
	private String firstName;

	/**
	 * Middle name of this person
	 */
	@Column(name = "MIDDLE_NAME", length = 50)
	@Getter
	@Setter
	private String middleName;

	/**
	 * Last name of this person
	 */
	@Column(name = "LAST_NAME", length = 50)
	@Getter
	@Setter
	private String lastName;

	/**
	 * Display name of this person
	 */
	@Column(name = "DISPLAY_NAME", length = 100)
	@Setter
	private String displayName;

	/**
	 * To get display name of this person.
	 * <p/>
	 * If no value is set explicitly to {@link Person#displayName} property then it
	 * returns a concatenation of {@link Person#firstName} and
	 * {@link Person#lastName} as the display name of this person
	 * 
	 * @return Display name of this person
	 */
	public String getDisplayName() {
		if (displayName == null || displayName.isEmpty()) {
			return firstName + lastName;
		} else {
			return displayName;
		}
	}

	/**
	 * Gender of this person<br/>
	 * {@code M} - Male<br/>
	 * {@code F} - Female<br/>
	 * {@code O} - Other
	 */
	@Column(name = "GENDER")
	@Getter
	@Setter
	private char gender;

	@Column(name = "DOB")
	@Getter
	@Setter
	private Date dob;

	/**
	 * Id of a {@link MaritalStatus} indicating marital status of this person
	 */
	@ManyToOne
	@JoinColumn(name = "MARITAL_STATUS_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private MaritalStatus maritalStatus;
}
