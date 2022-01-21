package com.gulukal.personservice.service;

import java.util.List;

public interface EntityService<T>{

    T create(T entity);
    T update(T entity, long id);
    List<T> getAll();
    T getById(long id);
    void delete(long id);
}
