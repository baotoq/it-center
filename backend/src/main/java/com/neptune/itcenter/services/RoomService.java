package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Room;
import com.neptune.itcenter.entities.RoomEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RoomService extends GenericService<RoomEntity, Room> {

    public RoomService() {
        super(RoomEntity.class);
    }

    public List<RoomEntity> findAll() {
        TypedQuery<RoomEntity> query = getEntityManager().createNamedQuery(RoomEntity.FIND_ALL, RoomEntity.class);
        return query.getResultList();
    }

    public RoomEntity update(Room room) {
        RoomEntity entity = findById(room.getId());
        return super.update(entity);
    }

    @Override
    public RoomEntity toEntity(Room bom) {
        if (bom == null)
            return null;
        RoomEntity entity = new RoomEntity();
        entity.setId(bom.getId());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeleteAt(bom.getDeleteAt());
        return entity;
    }

    @Override
    public Room toBom(RoomEntity entity) {
        if (entity == null)
            return null;
        Room bom = new Room();
        bom.setId(entity.getId());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeleteAt(entity.getDeleteAt());
        return bom;
    }
}
