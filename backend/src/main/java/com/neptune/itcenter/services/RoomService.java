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

    public RoomEntity update(Room bom) {
        RoomEntity entity = findById(bom.getId());
        entity.setActive(bom.isActive());
        return super.update(entity);
    }

    @Override
    public RoomEntity toEntity(Room bom) {
        if (bom == null)
            return null;
        RoomEntity entity = new RoomEntity();
        entity.setId(bom.getId());
        entity.setActive(bom.isActive());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeletedAt(bom.getDeleteAt());
        return entity;
    }

    @Override
    public Room toBom(RoomEntity entity) {
        if (entity == null)
            return null;
        Room bom = new Room();
        bom.setId(entity.getId());
        bom.setActive(entity.isActive());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeleteAt(entity.getDeletedAt());
        return bom;
    }
}
