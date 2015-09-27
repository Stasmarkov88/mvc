package com.spring.services;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
public interface AbstractCrudService<T extends Persistable<PK>, PK extends Serializable> {

    T findOne(PK id);

    T save(T entity);

    List<T> findAll();

    void delete(PK id) throws MessagingException;
}
