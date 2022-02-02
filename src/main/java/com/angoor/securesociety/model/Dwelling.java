/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.model;

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
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Entity
@Table(name = "DWELLINGS")
public class Dwelling extends EntityBase {
	/**
	 * Type of this Dwelling
	 * <p/>
	 * Since its mapping is set to {@code fetch=FetchType.LAZY}, this property will
	 * not be available by default. It will be fetched only when an attempt to
	 * access this property is made.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DWELLING_TYPE_ID", referencedColumnName = "ID")
	@Getter
	@Setter
	private DwellingType dwellingType;

	/**
	 * Id indicating the type of this Dwelling
	 * <p/>
	 * It's a read-only property as its mapping is set to {@code insertable=false}
	 * and {@code updatable=false}
	 */
	@Column(name = "DWELLING_TYPE_ID", insertable = false, updatable = false)
	@Getter
	@Setter
	private long dwellingTypeId;

	/**
	 * Society assigned unique number to this dwelling. It can be a combination of
	 * block number, floor number, and/or door number.
	 */
	@Column(name = "DWELLING_NUMBER")
	@Getter
	@Setter
	private String dwellingNumber;

	/**
	 * Door number of this dwelling
	 */
	@Column(name = "DOOR_NUMBER")
	@Getter
	@Setter
	private String doorNumber;

	/**
	 * Block in which this dwelling is located
	 */
	@Column(name = "BLOCK")
	@Getter
	@Setter
	private String block;

	/**
	 * Floor on which this dwelling is located
	 */
	@Column(name = "FLOOR_NUMBER")
	@Getter
	@Setter
	private int floorNumber;

	/**
	 * Total area of the dwelling in square feet
	 */
	@Column(name = "AREA")
	@Getter
	@Setter
	private float area;

	/**
	 * Undivided share of land for this dwelling
	 */
	@Column(name = "UDS")
	@Getter
	@Setter
	private float uds;
}
