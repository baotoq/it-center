package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.RoomEntity;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory extends GenericFactory<RoomEntity> {

    @Override
    public List<RoomEntity> createEntities(int amount) {
        List<RoomEntity> entities = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            RoomEntity entity = new RoomEntity();
            entity.setActive(faker.bool().bool());
            entities.add(entity);
        }
        return entities;
    }
}
