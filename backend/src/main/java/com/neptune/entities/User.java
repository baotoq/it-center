/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neptune.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Neptune
 */
@Entity
@NamedQueries({
    @NamedQuery(name = User.GET_BY_USER_NAME, query = "SELECT u FROM User u WHERE u.username = :username")
    ,
    @NamedQuery(name = User.GET_ALL, query = "SELECT u FROM User u")
})
public class User extends GenericEntity {

    public static final String GET_BY_USER_NAME = "User.findByUsername";

    public static final String GET_ALL = "User.findAll";

    private String name;
    private String username;
    private String password;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
