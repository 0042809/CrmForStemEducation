package com.youdev.crmforstemeducation.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void delete(ID id);
    boolean exists(ID id);
}