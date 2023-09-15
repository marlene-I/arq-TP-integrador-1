package com.tpe.interfaces;

import java.sql.SQLException;

public interface DAO<T> {
  public void insert(T element) throws SQLException;
  public void createTable() throws SQLException;
}
