package com.spring.services.impl;

import com.spring.services.AbstractCrudService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
public abstract class AbstractCrudServiceImpl<T extends Persistable<PK>, PK extends Serializable> implements AbstractCrudService<T, PK> {

    protected JpaRepository<T, PK> repository;

    @Override
    public T findOne(PK id) {
        return repository.findOne(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(PK id) throws MessagingException {
        repository.delete(id);
    }
}
