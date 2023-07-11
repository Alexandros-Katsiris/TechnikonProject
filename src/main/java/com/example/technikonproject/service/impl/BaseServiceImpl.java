package com.example.technikonproject.service.impl;

import com.example.technikonproject.base.BaseComponent;
import com.example.technikonproject.domain.BaseModel;
import com.example.technikonproject.service.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent
        implements BaseService<T, Long> {

    public abstract JpaRepository<T, Long> getRepository();

    @Override
    public T create(final T item) {
        logger.trace("Creating {}.", item);
        return getRepository().save(item);
    }

    @Override
    public T read(final Long id) {
        T item = getRepository().findById(id).orElseThrow();
        logger.trace("Item found matching id:{}.", id);
        return item;
    }

    //    @Override
//    public void update(final T item) {
//        logger.trace("Updating {}.", item);
//        getRepository().save(item);
//    }
    @Override
    public void update(T item) {
        if (!getRepository().existsById(item.getId())) {
            throw new RuntimeException("Cant update non-existing entity");
        }
        getRepository().save(item);
    }

    @Override
    public void deleteById(final Long id) {
        final T itemFound = getRepository().getReferenceById(id);
        logger.trace("Deleting {}.", itemFound);
        getRepository().deleteById(id);
    }

    @Override
    public void delete(final T item) {
        final T itemFound = getRepository().getReferenceById(item.getId());
        logger.trace("Deleting {}.", itemFound);
        getRepository().delete(itemFound);
    }
}