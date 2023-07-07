package com.example.technikonproject.service;

import com.example.technikonproject.domain.BaseModel;

public interface BaseService<T extends BaseModel, K> {

    T create(final T item);

    T read(K id);

    void update(T item);

    void deleteById(K id);

    void delete(T item);

}
