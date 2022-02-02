/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.contacts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.angoor.common.model.EntityBase;

import lombok.Getter;
import lombok.Setter;

/**
 * A person can have many types of addresses like "Office address", "Residence
 * address" etc.</br>
 * This {@link ContactAddress} class establishes a mapping between a
 * {@link Person} and an {@link Address} based on the usage of the address
 * 
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Entity
@Table(name = "CONTACT_ADDRESSES")
public class ContactAddress extends EntityBase {
	/**
	 * A {@link Person} to whom an address specified in the {@code address}
	 * property, is mapped to
	 * <p/>
	 * Since its mapping is set to {@code fetch=FetchType.LAZY}, this property will
	 * not be available by default. It will be fetched only when an attempt to
	 * access this property is made.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private Person person;

	/**
	 * Care of, usually, placed above the recipient line
	 */
	@Column(name = "CARE_OF", length = 100)
	@Getter
	@Setter
	private String careOf;

	/**
	 * An {@link Address} which is mapped to a person specified in the
	 * {@code person} property
	 * <p/>
	 * Since its mapping is set to {@code fetch=FetchType.LAZY}, this property will
	 * not be available by default. It will be fetched only when an attempt to
	 * access this property is made.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private Address address;

	/**
	 * An {@link AddressType} specifying the usage type of an address specified in
	 * the {@code address} property for a person specified in the {@code person}
	 * property
	 * <p/>
	 * Since its mapping is set to {@code fetch=FetchType.LAZY}, this property will
	 * not be available by default. It will be fetched only when an attempt to
	 * access this property is made.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_TYPE_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private AddressType addressType;
}
