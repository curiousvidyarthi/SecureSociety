/*
 * Copyright (c) 2021 Angoor, Inc. and/or its affiliates. All rights reserved.
 * Angoor Proprietary/Confidential. Use is subject to license terms.
 */
package com.angoor.securesociety.dao;

import org.springframework.stereotype.Repository;

import com.angoor.common.dao.GenericDAOImpl;
import com.angoor.securesociety.model.DwellingType;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Repository
public class DwellingTypeDAOImpl extends GenericDAOImpl<DwellingType, Long> implements DwellingTypeDAO {

}
