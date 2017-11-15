package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Room;
import com.neptune.itcenter.entities.RoomEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RoomService extends GenericService<RoomEntity, Room> {

    @EJB
    private ClassService classService;

    public RoomService() {
        super(RoomEntity.class, Room.class);
    }

    public List<RoomEntity> findAll() {
        TypedQuery<RoomEntity> query = getEntityManager().createNamedQuery(RoomEntity.FIND_ALL, RoomEntity.class);
        return query.getResultList();
    }

    public RoomEntity update(Room bom) {
        RoomEntity entity = findById(bom.getId());
        entity.setCapacity(bom.getCapacity());
        entity.setActive(bom.isActive());
        return super.update(entity);
    }

    @Override
    public RoomEntity toEntity(Room bom) {
        if (bom == null)
            return null;
        RoomEntity entity = super.toEntity(bom);
        entity.setCapacity(bom.getCapacity());
        entity.setActive(bom.isActive());
        return entity;
    }

    @Override
    public Room toBom(RoomEntity entity) {
        if (entity == null)
            return null;
        Room bom = super.toBom(entity);
        bom.setCapacity(entity.getCapacity());
        bom.setActive(entity.isActive());
        return bom;
    }
}
