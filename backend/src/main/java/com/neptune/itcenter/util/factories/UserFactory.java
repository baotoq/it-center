package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.boms.Role;
import com.neptune.itcenter.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserFactory extends GenericFactory<UserEntity> {

    @Override
    public List<UserEntity> createEntities(int amount) {
        List<UserEntity> entities = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
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
        int levelOrder = faker.random().nextInt(3);
        switch (levelOrder) {
            case 0:
                return Role.ADMIN;
            case 1:
                return Role.STAFF;
            case 2:
                return Role.USER;
            default:
                return Role.USER;
        }
    }
}
