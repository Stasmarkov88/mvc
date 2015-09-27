package com.spring.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Entity
@Table(name = "User")
public class User extends AbstractPersistable<Long> {

    @NotNull(message = "пожалуйста, заполните это поле")
//    @Pattern(regexp = "\\d{1,2}", message = "пожалуйста, введите число")
    @Min(value = 16, message = "возраст должен быть старше 16")
    @Max(value = 100, message = "вам действительно больше 100 лет?)))")
    @Column(name = "age")
    private Integer age;

    @Size(min = 2, max = 30, message = "логин должен содержать {min} - {max} символов")
    @Column(name = "login")
    private String login;

    @Size(min = 8, max = 30, message = "пароль должен содержать {min} - {max} символов")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "[a-zA-Z-\\d_$\\+\\.]+@[a-z]+\\.[a-z]+", message = "некорректнаый email. Пример:email@gmail.com")
    @Column(name = "email")
    private String email;

    public User() {
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
}
