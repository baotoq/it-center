package com.neptune.itcenter.entities;

import com.neptune.itcenter.boms.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = UserEntity.FIND_ALL, query = "SELECT t FROM UserEntity t"),
})
public class UserEntity extends GenericEntity {

    public static final String FIND_ALL = "UserEntity.findAll";

    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean active;

    public UserEntity() {
    }

    public UserEntity(String name, Role role, String username, String password) {
        this.name = name;
        this.role = role;
        this.username = username;
        this.password = password;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
