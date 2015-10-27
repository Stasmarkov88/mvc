package com.spring.domain;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Entity
@Table(name = "User")
public class User implements Persistable<Long>, Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "пожалуйста, заполните это поле")
    @Min(value = 16, message = "возраст должен быть старше 16")
    @Max(value = 100, message = "вам действительно больше 100 лет?)))")
    @Column(name = "age")
    private Integer age;

    @Size(min = 2, max = 30, message = "логин должен содержать {min} - {max} символов")
    @Column(name = "login", unique = true)
    private String login;

    @Size(min = 8, message = "пароль должен содержать минимум {min} символов")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "[a-zA-Z-\\d_$\\+\\.]+@[a-z]+\\.[a-z]+", message = "некорректнаый email. Пример:email@gmail.com")
    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "login", referencedColumnName = "login")
    private List<UserRole> roles = new ArrayList<>();

    public User() {
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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(age, user.age) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age, login, password, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
