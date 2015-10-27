package com.spring.services.impl;

import com.spring.domain.User;
import com.spring.domain.UserRole;
import com.spring.repository.UserRepository;
import com.spring.services.UserService;
import com.spring.types.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Transactional
@Service
public class UserServiceImpl extends AbstractCrudServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        repository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.isNew()){
            encryptPassword(user);
            setRole(user);
        }
        userRepository.save(user);
        return user;
    }

    private void encryptPassword(User user) {
        String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
    }

    private void setRole(User user) {
        UserRole role = new UserRole();
        role.setRole(UserRoles.USER);
        user.getRoles().add(role);
    }

    @Override
    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return user;
    }
}
