/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neptune.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Neptune
 */
@Entity
@NamedQueries({
    @NamedQuery(name = User.GET_ALL, query = "SELECT u FROM User u")
})
public class Subject extends GenericEntity {
    
    public static final String GET_ALL = "Subject.getAll";
}
