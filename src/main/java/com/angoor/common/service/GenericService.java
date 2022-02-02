/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.common.service;

import java.util.List;

import org.springframework.lang.NonNull;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
public interface GenericService<E, K> {
	/**
	 * To add a given entity
	 * 
	 * @param entity An entity to add
	 */
	void add(@NonNull E entity);

	/**
	 * To add or update a given entity
	 * 
	 * @param entity An entity to add or update
	 */
	void addOrUpdate(E entity);

	/**
	 * To update a given entity
	 * 
	 * @param entity An entity to update
	 */
	void update(@NonNull E entity);

	/**
	 * To delete a given entity
	 * 
	 * @param entity An entity to delete
	 */
	void delete(@NonNull E entity);

	/**
	 * To delete an entity by its Id (primary key)
	 * 
	 * @param id An Id to delete the associated entity
	 */
	int deleteById(K id);

	/**
	 * To get an entity by Id
	 * 
	 * @param id An Id to get the associated entity
	 * @return An entity associated with the given Id, or {@code null} is no such
	 *         entity found
	 */
	E getById(K id);

	/**
	 * To list the entities
	 * <p/>
	 * To filter based on active status
	 * ({@link com.angoor.common.model.EntityBase#isActive isActive} property of the
	 * entities) use either {@link #listActive(int, int)} or
	 * {@link #listInactive(int, int)} method
	 * 
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list of entities
	 */
	List<E> list(int startIdx, int noOfResults);

	/**
	 * To list active entities. An active entity will have {@code true} value for
	 * its {@link com.angoor.common.model.EntityBase#isActive isActive} property.
	 * 
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list of active entities
	 */
	List<E> listActive(int startIdx, int noOfResults);

	/**
	 * To list inactive entities. An inactive entity will have {@code false} value
	 * for its {@link com.angoor.common.model.EntityBase#isActive isActive}
	 * property.
	 * 
	 * @param startIdx    Index from which the result should include the entities
	 * @param noOfResults Maximum number of entities to be included in the result
	 * @return A list of inactive entities
	 */
	List<E> listInactive(int startIdx, int noOfResults);
}
