package com.spring.domain;

import com.spring.types.UserRoles;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Entity
@Table(name = "User_role")
public class UserRole implements Persistable<Long>, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role")
    private UserRoles role;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return null == getId();
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }
}
