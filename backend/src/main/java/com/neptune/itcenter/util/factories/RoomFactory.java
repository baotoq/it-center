package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.RoomEntity;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory extends GenericFactory<RoomEntity> {
    public RoomFactory() {
        super(FactoryConstants.ROOM_AMOUNT);
    }

    @Override
    public List<RoomEntity> createEntities() {
        List<RoomEntity> entities = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            RoomEntity entity = new RoomEntity();
            entities.add(entity);
        }
        return entities;
    }
}
