package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.User;
import com.neptune.itcenter.entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserService extends GenericService<UserEntity, User> {

    public UserService() {
        super(UserEntity.class, User.class);
    }

    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery(UserEntity.FIND_ALL, UserEntity.class);
        return query.getResultList();
    }

    public UserEntity findByUsername(String username) {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery(UserEntity.FIND_BY_USER_NAME, UserEntity.class)
                .setParameter("username", username);
        List<UserEntity> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else return results.get(0);
    }

    public UserEntity findByUserId(Integer id) {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery(UserEntity.FIND_BY_USER_ID, UserEntity.class)
                .setParameter("userId", id);
        List<UserEntity> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else return results.get(0);
    }

    public UserEntity update(User bom) {
        UserEntity entity = findById(bom.getId());
        entity.setId(bom.getId());
        entity.setName(bom.getName());
        entity.setRole(bom.getRole());
        entity.setUsername(bom.getUsername());
        entity.setPassword(bom.getPassword());
        return super.update(entity);
    }

    public boolean isExistingUsername(String username) {
        return findByUsername(username) != null;
    }

    public boolean authenticate(String username, String password) {
        UserEntity entity = findByUsername(username);
        return entity != null && password.equals(entity.getPassword());
    }

    @Override
    public UserEntity toEntity(User bom) {
        if (bom == null)
            return null;
        UserEntity entity = findById(bom.getId());
        entity.setName(bom.getName());
        entity.setRole(bom.getRole());
        entity.setUsername(bom.getUsername());
        entity.setPassword(bom.getPassword());
        return entity;
    }

    @Override
    public User toBom(UserEntity entity) {
        if (entity == null)
            return null;
        User bom = super.toBom(entity);
        bom.setName(entity.getName());
        bom.setRole(entity.getRole());
        bom.setUsername(entity.getUsername());
        bom.setPassword(entity.getPassword());
        return bom;
    }
}
