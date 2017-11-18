package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.boms.Role;
import com.neptune.itcenter.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserFactory extends GenericFactory<UserEntity> {
    public UserFactory(int amount) {
        super(amount);
    }

    @Override
    public List<UserEntity> createEntities() {
        List<UserEntity> entities = new ArrayList<>();

        for (int i = 0; i < getAmount(); i++) {
            UserEntity entity = new UserEntity();
            entity.setName(faker.name().fullName());
            entity.setRole(generateRole());
            entity.setUsername(faker.name().username());
            entity.setPassword("1");
            entities.add(entity);
        }
        return entities;
    }

    private Role generateRole() {
        int levelOrder = faker.random().nextInt(2);
        switch (levelOrder) {
            case 0:
                //return Role.ADMIN;
                return Role.USER;
            case 1:
                return Role.USER;
            default:
                return Role.USER;
        }
    }
}
