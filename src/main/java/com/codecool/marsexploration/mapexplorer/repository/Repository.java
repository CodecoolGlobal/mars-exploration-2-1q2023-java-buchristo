package com.codecool.marsexploration.mapexplorer.repository;

import java.util.List;

public interface Repository<T> {
    T getById(int id);
    List<T> getAll();
    void insert(T entity);
    void update(T entity);
    void delete(int id);
    void deleteAll();
}
