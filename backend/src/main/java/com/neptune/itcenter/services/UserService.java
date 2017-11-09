package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.User;
import com.neptune.itcenter.entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserService extends GenericService<UserEntity, User> {

    public UserService() {
        super(UserEntity.class);
    }

    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery(UserEntity.FIND_ALL, UserEntity.class);
        return query.getResultList();
    }

    public UserEntity update(User user) {
        UserEntity entity = findById(user.getId());
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setRole(user.getRole());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        return super.update(entity);
    }

    @Override
    public UserEntity toEntity(User bom) {
        if (bom == null)
            return null;
        UserEntity entity = new UserEntity();
        entity.setId(bom.getId());
        entity.setName(bom.getName());
        entity.setRole(bom.getRole());
        entity.setUsername(bom.getUsername());
        entity.setPassword(bom.getPassword());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeleteAt(bom.getDeleteAt());
        return entity;
    }

    @Override
    public User toBom(UserEntity entity) {
        if (entity == null)
            return null;
        User bom = new User();
        bom.setId(entity.getId());
        bom.setName(entity.getName());
        bom.setRole(entity.getRole());
        bom.setUsername(entity.getUsername());
        bom.setPassword(entity.getPassword());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeleteAt(entity.getDeleteAt());
        return bom;
    }
}
