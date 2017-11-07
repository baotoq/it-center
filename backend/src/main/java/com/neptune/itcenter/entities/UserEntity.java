package com.neptune.itcenter.entities;

import com.neptune.itcenter.boms.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends GenericEntity {

    public UserEntity(String name, Role role, String username, String password) {
        this.name = name;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private String username;

    @Column
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
