package com.spring.services;

import com.spring.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Transactional
@Service
public interface UserService extends AbstractCrudService<User, Long> {
    User findByLogin(String login);
}
