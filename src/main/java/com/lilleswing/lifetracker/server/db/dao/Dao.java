package com.lilleswing.lifetracker.server.db.dao;

import java.util.List;

public interface Dao<T> {

	public List<? extends T> getAll();

	public T getById(long id);

	public T add(T t);
}
