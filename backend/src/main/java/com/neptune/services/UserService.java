/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neptune.services;

import com.neptune.entities.User;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Neptune
 */
@Service
@Transactional
public class UserService extends GenericService<User> {

    public UserService() {
        super(User.class);
    }

    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createNamedQuery(User.GET_ALL, User.class);
        return query.getResultList();
    }
}
