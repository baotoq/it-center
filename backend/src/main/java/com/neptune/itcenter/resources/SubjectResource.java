package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Subject;
import com.neptune.itcenter.entities.SubjectEntity;
import com.neptune.itcenter.services.SubjectService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Stateless
@Path("subjects")
public class SubjectResource extends GenericResource {
    @EJB
    private SubjectService subjectService;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Subject get(@PathParam("id") Integer id) {
        SubjectEntity subjectEntity = subjectService.findById(id);
        return subjectService.toBom(subjectEntity);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Subject> getAll() {
        List<SubjectEntity> subjectEntities = subjectService.findAll();
        return subjectService.toBoms(subjectEntities);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@Valid Subject subject) {
        SubjectEntity subjectEntity = subjectService.add(subject);
        URI createdUri = appendCurrentUriWith(String.valueOf(subjectEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, @Valid Subject subject) {
        subject.setId(id);
        subjectService.update(subjectService.toEntity(subject));
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        SubjectEntity subjectEntity = subjectService.findById(id);
        subjectService.delete(subjectEntity);
        return Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public int count() {
        return subjectService.findAll().size();
    }
}
