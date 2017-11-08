package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Room;
import com.neptune.itcenter.entities.RoomEntity;

public class RoomService extends GenericService<RoomEntity, Room> {

    public RoomService() {
        super(RoomEntity.class);
    }

    @Override
    public RoomEntity toEntity(Room bom) {
        return null;
    }

    @Override
    public Room toBom(RoomEntity entity) {
        return null;
    }
}
