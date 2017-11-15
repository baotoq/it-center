package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Class;
import com.neptune.itcenter.entities.ClassEntity;
import com.neptune.itcenter.services.ClassService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Stateless
@Path("classes")
public class ClassResource extends GenericResource {

    @EJB
    private ClassService classService;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Class get(@PathParam("id") Integer id) {
        ClassEntity classEntity = classService.findById(id);
        return classService.toBom(classEntity);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Class> getAll() {
        List<ClassEntity> classEntities = classService.findAll();
        return classService.toBoms(classEntities);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@Valid Class bom) {
        ClassEntity classEntity = classService.add(bom);
        URI createdUri = appendCurrentUriWith(String.valueOf(classEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, Class bom) {
        bom.setId(id);
        classService.update(classService.toEntity(bom));
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        ClassEntity classEntity = classService.findById(id);
        classService.delete(classEntity);
        return Response.noContent().build();
    }
}
