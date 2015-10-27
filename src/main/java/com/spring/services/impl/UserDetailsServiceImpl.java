package com.spring.services.impl;

import com.google.common.collect.Sets;
import com.spring.domain.User;
import com.spring.domain.UserRole;
import com.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findByLogin(login);
        Set<GrantedAuthority> roles = getRoles(user);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                        user.getPassword(), roles);
        return userDetails;
    }

    private Set<GrantedAuthority> getRoles(User user) {
        Set<GrantedAuthority> grantedAuthorities = Sets.newHashSet();
        for (UserRole role: user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }
        return grantedAuthorities;
    }
}
