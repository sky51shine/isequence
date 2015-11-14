package com.uulookingfor.isequence.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T, Q> {

	long insert(T dataObject) throws SQLException;

	int update(T dataObject) throws SQLException;

	int delete(long id) throws SQLException;

	List<T> query(Q query) throws SQLException;

	int count(Q query) throws SQLException;

}
