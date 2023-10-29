package com.edemarcos.tcc.domain.user.entities;

import com.edemarcos.tcc.domain.user.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;

public class User {
    private Long id;
    private String name;
    private String login;
    private String email;
    private String password;
    private UserRole role;
    private LocalDateTime registrationDate;
    private Boolean isActivated;

    private Collection<? extends GrantedAuthority> authorities;

    public User() {
    }

    public User(Long id, String name, String login, String email, String password, UserRole role, LocalDateTime registrationDate, Boolean activated) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
        this.isActivated = activated;
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.login = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getActivated() {
        return isActivated;
    }

    public void setActivated(Boolean activated) {
        isActivated = activated;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
