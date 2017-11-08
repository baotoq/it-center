package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Room;
import com.neptune.itcenter.entities.RoomEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public class RoomService extends GenericService<RoomEntity, Room> {

    public RoomService() {
        super(RoomEntity.class);
    }

    public List<RoomEntity> findAll() {
        TypedQuery<RoomEntity> query = getEntityManager().createNamedQuery(RoomEntity.FIND_ALL, RoomEntity.class);
        return query.getResultList();
    }

    public RoomEntity add(Room room) {
        return super.add(toEntity(room));
    }

    public RoomEntity update(Room room) {
        RoomEntity entity = findById(room.getId());
        return super.update(entity);
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
