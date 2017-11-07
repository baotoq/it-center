/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neptune.services;

import com.neptune.entities.Article;
import com.neptune.entities.GenericEntity;
import com.neptune.entities.UserEntity;
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
public class UserService extends GenericService<GenericEntity> {

    public UserEntity get(int id) {
        return entityManager.find(UserEntity.class, id);
    }

    public List<UserEntity> getAll() {
        TypedQuery<UserEntity> query = entityManager.createNamedQuery(UserEntity.FIND_ALL, UserEntity.class);
        return query.getResultList();
    }
}
