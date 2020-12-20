package com.gridnine.testing.dao;

import java.util.List;
/**
 * 20.12.2020
 * Dao
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public interface Dao<T> {
    List<T> findAll();
}
