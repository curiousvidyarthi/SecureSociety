/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@MappedSuperclass()
public abstract class EntityBase {
	/**
	 * Primary Key of this entity
	 */
	@Id
	@GeneratedValue
	@Column(name = "ID")
	@Getter
	@Setter
	protected long id;

	/**
	 * Specifies whether this entity is active ({@code true}) or inactive
	 * ({@code false}). The default value is {@code true}.
	 */
	@Column(name = "IS_ACTIVE", nullable = false)
	@ColumnDefault(value = "true")
	@Getter
	@Setter
	protected boolean isActive = true;

	/**
	 * Created timestamp
	 */
	@Column(name = "CREATED_AT")
	@CreationTimestamp
	@Getter
	@Setter
	protected Date createdAt;

	/**
	 * Last updated timestamp
	 */
	@Column(name = "UPDATED_AT")
	@UpdateTimestamp
	@Getter
	@Setter
	protected Date updatedAt;
}
