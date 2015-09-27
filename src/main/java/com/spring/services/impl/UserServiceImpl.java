package com.spring.services.impl;

import com.spring.domain.User;
import com.spring.repository.UserRepository;
import com.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Service
public class UserServiceImpl extends AbstractCrudServiceImpl<User, Long> implements UserService {

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        repository = userRepository;
    }
}
